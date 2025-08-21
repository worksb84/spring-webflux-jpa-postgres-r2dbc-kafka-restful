package com.example.demo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.example.demo.domain.HotelMaster;

public interface HotelMasterRepository extends ReactiveCrudRepository<HotelMaster, Long> {

}
