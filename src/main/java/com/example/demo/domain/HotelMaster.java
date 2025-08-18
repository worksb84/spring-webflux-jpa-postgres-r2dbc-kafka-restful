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
@Table(name = "hotel_masters")
public class HotelMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameKor;
    private String nameEng;
    private String locationKor;
    private String locationEng;
    private String gradeCode;
    private double averageRating;
    private String address;
    private double defaultPrice;
    private double discountRate;
    private double latitude;
    private double longitude;
    private Timestamp createdAt;
    @Nullable
    private Timestamp modifiedAt;
    private Timestamp deletedAt;
}
