package com.patika.rsakin.patikarentacarservice.repository;

import com.patika.rsakin.patikarentacarservice.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
