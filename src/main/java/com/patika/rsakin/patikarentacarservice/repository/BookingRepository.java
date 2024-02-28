package com.patika.rsakin.patikarentacarservice.repository;

import com.patika.rsakin.patikarentacarservice.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    // price > 300
    List<Booking> getAllByPriceGreaterThan(int price);

    // booking.price > 300 && booking.name LIKE "%abc%"
    List<Booking> getAllByPriceGreaterThanAndNameContainsIgnoreCase(int price, String name);

    // booking.price > 300 && booking.name LIKE "%abc%"
    List<Booking> getAllByCar_KmAndCar_Model_Name(int km, String carModelName);

}