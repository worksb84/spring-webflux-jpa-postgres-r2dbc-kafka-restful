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
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String reservationCode;
    private long userId;
    private String productTypeCode;
    private long productMasterId;
    private long productDetailId;
    private double adultPrice;
    private long adultCount;
    private double childPrice;
    private long childCount;
    private double infantPrice;
    private long infantCount;
    private Timestamp createdAt;
}
