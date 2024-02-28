package com.patika.rsakin.patikarentacarservice.controller;

import com.patika.rsakin.patikarentacarservice.model.dto.UserDTO;
import com.patika.rsakin.patikarentacarservice.model.entity.User;
import com.patika.rsakin.patikarentacarservice.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDTO, User.class);
        User savedUser = userService.createUser(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        ModelMapper modelMapper = new ModelMapper();
        List<User> users = userService.getAllUsers();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

}