package com.example.dbd_pj_be.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Data
public class User {
    @Id
    private Long id;
    private String name;
    private String password;
    private int age;
    private String gender;
    private String phone;
    private String email;
    private final LocalDateTime regTime;
//    private Integer role;  // 1--User , 2--Vendor ， 3--Admin
    // Constructors, getters, setters, and other methods
    // Constructors
    public User() {
        this.regTime = LocalDateTime.now();
    }

    public User(String name, String password, int age, String gender, String phone, String email) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.regTime = LocalDateTime.now();
    }

    // Getters and Setters (You can use your IDE to generate these)

    // Equals and HashCode methods (You can use your IDE to generate these)

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", regTime=" + regTime +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
