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
@Table(name = "reservations")
public class Reservation {
    @Id
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
