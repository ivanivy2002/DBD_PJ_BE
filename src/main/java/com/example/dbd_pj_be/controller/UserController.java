package com.example.dbd_pj_be.controller;


import com.example.dbd_pj_be.entity.User;
import com.example.dbd_pj_be.repo.UserRepository;
//import com.example.dbd_pj_be.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/displayUser")
    public List<User> findAll(){
        return userRepository.findAll();
    }

//    private final UserServiceImpl userService;
//
//    @Autowired
//    public UserController(UserServiceImpl userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
//
//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable Long id) {
//        return userService.getUserById(id);
//    }
//
//    @PostMapping
//    public User createUser(@RequestBody User user) {
//        return userService.createUser(user);
//    }
//
//    @PutMapping("/{id}")
//    public User updateUser(@PathVariable Long id, @RequestBody User user) {
//        return userService.updateUser(id, user);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//    }
//
//    @GetMapping("/login")
//    public User login(@RequestParam String userName, @RequestParam String password, @RequestParam Integer role) {
//        return userService.login(userName, password, role);
//
//    }
}
