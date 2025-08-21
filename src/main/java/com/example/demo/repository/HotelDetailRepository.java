package com.example.demo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.example.demo.domain.HotelDetail;

public interface HotelDetailRepository extends ReactiveCrudRepository<HotelDetail, Long> {

}
