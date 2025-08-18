package com.example.demo.domain;

import java.sql.Timestamp;

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
@Table(name = "hotel_details")
public class HotelDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long hotelMasterId;
    private String nameKor;
    private String nameEng;
    private String descriptionKor;
    private String descriptionEng;
    private String roomCode;
    private double defaultPrice;
    private double discountRate;
    private int minPeople;
    private int maxPeople;
    private String available;
    private String facilities;
    private String chackinAt;
    private String chackOutAt;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
    private Timestamp deletedAt;
}
