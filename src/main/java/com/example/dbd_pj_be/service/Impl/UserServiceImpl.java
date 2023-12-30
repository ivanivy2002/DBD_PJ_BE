package com.example.dbd_pj_be.service.Impl;//package com.example.dbd_pj_be.service.Impl;
//
////import com.example.dbd_pj_be.entity.User;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.example.dbd_pj_be.entity.User;
//import com.example.dbd_pj_be.mapper.UserMapper;
//import com.example.dbd_pj_be.repo.UserRepository;
//import com.example.dbd_pj_be.service.IUserService;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
//
//    private UserRepository userRepository;
//
//    @Autowired
//    public void UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    public User getUserById(Long id) {
//        Optional<User> userOptional = userRepository.findById(id);
//        return userOptional.orElse(null);
//    }
//
//    public User createUser(User user) {
//        return userRepository.save(user);
//    }
//
//    public User updateUser(Long id, User user) {
//        if (userRepository.existsById(id)) {
//            user.setId(id);
//            return userRepository.save(user);
//        }
//        return null;
//    }
//
//    public void deleteUser(Long id) {
//        userRepository.deleteById(id);
//    }
//
//    @Override
//    public void reg(User user) {
//
//    }
//
//    @Override
//    public User login(String userName, String password, Integer role) {
//        return null;
//    }
//
//    @Override
//    public void changePassword(String password, String newPassword, Integer userId) {
//
//    }
//
//    @Override
//    public void changeInfo(User user) {
//
//    }
//
//    @Override
//    public User displayInfo(Integer userId) {
//        return null;
//    }
//
//    @Override
//    public String encrypt(String text) {
//        return null;
//    }
//
//    @Override
//    public String decrypt(String encodedText) {
//        return null;
//    }
//
//    @Override
//    public User findByUserName(String userName) {
//        return null;
//    }
//
//    @Override
//    public User findByPhoneNumber(String phoneNumber) {
//        return null;
//    }
//
//    @Override
//    public User findByIdNumber(String idNumber) {
//        return null;
//    }
//
//    @Override
//    public User findByEmail(String email) {
//        return null;
//    }
//
//    @Override
//    public User findById(Integer id) {
//        return null;
//    }
//
//    @Override
//    public Integer getIdFromSession(HttpSession session) {
//        return null;
//    }
//
//    @Override
//    public Integer getRoleFromSession(HttpSession session) {
//        return null;
//    }
//
//    @Override
//    public String getUserNameFromSession(HttpSession session) {
//        return null;
//    }
//}
