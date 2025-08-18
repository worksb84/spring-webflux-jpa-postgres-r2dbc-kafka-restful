package com.example.demo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Reservation;

@Repository
public interface ReservationRepository extends ReactiveCrudRepository<Reservation, Long> {

}
