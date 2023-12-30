package com.example.dbd_pj_be.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.dbd_pj_be.entity.User;
import jakarta.servlet.http.HttpSession;

//import javax.servlet.http.HttpSession;

public interface IUserService extends IService<User> {

    /* 用户注册 */
    void reg(User user);

    /* 用户登录 */
    User login(String userName, String password, Integer role);

    void changePassword(String password, String newPassword, Integer userId);

    void changeInfo(User user);

    User displayInfo(Integer userId);
    /* 密码加密 */
    String encrypt(String text);

    /* 密码解密 */
    String decrypt(String encodedText);


    /* 设计不同查找函数，防止同一用户名、手机号、身份证号、邮箱被多次注册 */
    User findByUserName(String userName);
    User findByPhoneNumber(String phoneNumber);
    User findByIdNumber(String idNumber);
    User findByEmail(String email);
    User findById(Integer id);


    // 测试函数，最后可删除
    Integer getIdFromSession(HttpSession session);
    Integer getRoleFromSession(HttpSession session);
    String getUserNameFromSession(HttpSession session);

}
