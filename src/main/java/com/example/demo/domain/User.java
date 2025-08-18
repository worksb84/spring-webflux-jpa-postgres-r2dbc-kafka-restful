package com.example.demo.domain;

import java.sql.Timestamp;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String nickname;
    private String password;
    private String role;
    private Timestamp loginAt;
    private Timestamp createdAt;
    @Nullable
    private Timestamp modifyAt;
    @Nullable
    private Timestamp deleteAt;
}
