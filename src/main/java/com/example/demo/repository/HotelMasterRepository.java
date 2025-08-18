package com.example.demo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.HotelMaster;

@Repository
public interface HotelMasterRepository extends ReactiveCrudRepository<HotelMaster, Long> {

}
