package com.example.dbd_pj_be.repo;

import com.example.dbd_pj_be.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 这里可以定义一些自定义的查询方法
}
