package com.patika.rsakin.patikarentacarservice.repository;

import com.patika.rsakin.patikarentacarservice.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
