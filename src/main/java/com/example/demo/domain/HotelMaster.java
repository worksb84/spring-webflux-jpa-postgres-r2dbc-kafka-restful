package com.example.demo.domain;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded.Nullable;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "hotel_masters")
public class HotelMaster {
    @Id
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
