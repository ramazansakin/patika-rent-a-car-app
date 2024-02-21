package com.patika.rsakin.patikarentacarservice.service;

import com.patika.rsakin.patikarentacarservice.model.dto.CarDTO;
import com.patika.rsakin.patikarentacarservice.model.entity.Car;
import com.patika.rsakin.patikarentacarservice.model.mapper.CarMapper;
import com.patika.rsakin.patikarentacarservice.repository.CarRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    private final CarMapper carMapper = Mappers.getMapper(CarMapper.class);

    public CarDTO createCar(CarDTO carDTO) {
        Car car = carMapper.toEntity(carDTO);
        Car savedCar = carRepository.save(car);
        return carMapper.toDTO(savedCar);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public Car updateCar(Long id, Car updatedCar) {
        updatedCar.setId(id);
        return carRepository.save(updatedCar);
    }

}