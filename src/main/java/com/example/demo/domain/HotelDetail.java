package com.example.demo.domain;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
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
@Table(name = "hotel_details")
public class HotelDetail {
    @Id
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
