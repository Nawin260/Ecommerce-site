package com.example.userdetails.Service;

import com.example.userdetails.DTO.UserDto;
import com.example.userdetails.Entity.User;
import com.example.userdetails.Repository.AddressRepo;
import com.example.userdetails.Repository.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EmailService emailService;

    public UserDto createUser(UserDto userDto) {
        Optional<User> userdtl = userRepository.findByEmail(userDto.getEmail());

        if (userdtl.isPresent()) {
            throw new RuntimeException("User with this email already exists");
        }
        User user = modelMapper.map(userDto, User.class);
        user.setCreatedTime(LocalDateTime.now());
        User savedUser = userRepository.save(user);
        emailService.sendEmail(user.getEmail(), "Welcome to Online Fashion Service", "Your account has been created successfully!");

        return modelMapper.map(savedUser, UserDto.class);
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    public UserDto getUserById(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapper.map(user, UserDto.class);
    }

    @Transactional
    public void deleteUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            User existingUser = user.get();
            addressRepo.deleteByUserId(existingUser.getUserid()); // First, delete addresses
            userRepository.delete(existingUser); // Then, delete user
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
