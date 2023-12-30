package com.example.dbd_pj_be.controller;


import com.example.dbd_pj_be.common.Result;
import com.example.dbd_pj_be.entity.User;
import com.example.dbd_pj_be.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;
//    @GetMapping("/displayUser")
//    public List<User> findAll(){
//        return userRepository.findAll();
//    }

//    private final UserServiceImpl userService;
//
//    @Autowired
//    public UserController(UserServiceImpl userService) {
//        this.userService = userService;
//    }
//
    @GetMapping("/displayUser")
    public Result<List<User>> displayUser() {
        Result<List<User>> result = new Result<>();
        result.succ(userRepository.findAll());
        return result;
    }

    



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
