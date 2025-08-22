package com.example.demo.domain;

import java.sql.Timestamp;

import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "users")
public class User {
    @Id
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
