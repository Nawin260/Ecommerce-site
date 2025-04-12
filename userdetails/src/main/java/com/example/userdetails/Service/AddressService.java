package com.example.userdetails.Service;

import com.example.userdetails.DTO.AddressDTO;
import com.example.userdetails.Entity.Address;
import com.example.userdetails.Entity.User;
import com.example.userdetails.Repository.AddressRepo;
import com.example.userdetails.Repository.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AddressRepo addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public AddressDTO createAddress(AddressDTO addressDTO) {
        Address address=new Address();
        address.setState(addressDTO.getState());
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());
        address.setZip(addressDTO.getZip());
//        Address address = modelMapper.map(addressDTO, Address.class);
        User user = userRepo.findById(addressDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        address.setUser(user);
        Address savedAddress = addressRepository.save(address);
        return new AddressDTO(savedAddress);
//        return modelMapper.map(savedAddress, AddressDTO.class);
    }
    @Transactional
    public List<AddressDTO> getUsersByCity(String city) {
        return addressRepository.findByCity(city).stream()
                .map(address -> modelMapper.map(address, AddressDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public AddressDTO updateAddress(int id, AddressDTO addressDTO) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address not found"));
        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setZip(addressDTO.getZip());
        Address updatedAddress = addressRepository.save(address);
        return modelMapper.map(updatedAddress, AddressDTO.class);
    }
}
