package com.example.userdetails.Controller;

import com.example.userdetails.DTO.UserDto;
import com.example.userdetails.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping("/me")
//    public ResponseEntity<Map<String, Object>> getAuthenticatedUser(@AuthenticationPrincipal OidcUser oidcUser) {
//        if (oidcUser != null) {
//            return ResponseEntity.ok(oidcUser.getAttributes()); // Returns Google profile details
//        } else {
//            return ResponseEntity.badRequest().build();
//        }
//    }

    @GetMapping("/")
    public String greet(){
        return "Hello There welcome to Online-Fashion ";
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto savedUserDto = userService.createUser(userDto);
        return ResponseEntity.ok(savedUserDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable long id) {
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/delete")
    public String deleteUserByEmail(@RequestParam String email) {
        userService.deleteUserByEmail(email);
        return "User Deleted Successfully";
    }


}
