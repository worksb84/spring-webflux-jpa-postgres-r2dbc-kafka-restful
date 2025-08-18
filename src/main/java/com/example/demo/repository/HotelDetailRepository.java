package com.example.demo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.HotelDetail;

@Repository
public interface HotelDetailRepository extends ReactiveCrudRepository<HotelDetail, Long> {

}
