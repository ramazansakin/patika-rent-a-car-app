package com.patika.rsakin.patikarentacarservice.service;

import com.patika.rsakin.patikarentacarservice.model.dto.CarDTO;
import com.patika.rsakin.patikarentacarservice.model.entity.Brand;
import com.patika.rsakin.patikarentacarservice.model.entity.Car;
import com.patika.rsakin.patikarentacarservice.model.entity.Model;
import com.patika.rsakin.patikarentacarservice.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @Test
    public void getCarById_WithValidId_ReturnsCar() {
        // Initialize step
        Long id = 1L;
        Car expectedCar = new Car();
        expectedCar.setBrand(new Brand("Toyota"));
        expectedCar.setModel(new Model("Camry"));
        expectedCar.setId(id);

        // stubbing step
        when(carRepository.findById(id)).thenReturn(Optional.of(expectedCar));

        // test 3
        Car actualCar = carService.getCarById(id);

        assertNotNull(actualCar);
        assertEquals(actualCar.getBrand().getName(), expectedCar.getBrand().getName());
        assertEquals(actualCar.getModel().getName(), expectedCar.getModel().getName());
    }

    @Test
    public void createCar_CreatesNewCar() {
        CarDTO carDTO = new CarDTO();
        carDTO.setBrandName("Toyota");
        carDTO.setModelName("Camry");

        Car car = new Car();
        car.setBrand(new Brand("Toyota"));
        car.setModel(new Model("Camry"));


        when(carRepository.save(any(Car.class))).thenReturn(car);

        CarDTO createdCar = carService.createCar(carDTO);

        assertNotNull(createdCar);
        assertEquals("Toyota", createdCar.getBrandName());
        assertEquals("Camry", createdCar.getModelName());
    }

    @Test
    public void updateCar_WithValidId_UpdatesExistingCar() {
        Long id = 1L;

        Car updatedCar = new Car();
        updatedCar.setBrand(new Brand("Toyota"));
        updatedCar.setModel(new Model("Corolla"));
        updatedCar.setId(id);

        when(carRepository.save(any(Car.class))).thenReturn(updatedCar);

        Car updatedCarResult = carService.updateCar(id, updatedCar);

        assertNotNull(updatedCarResult);
        assertEquals("Toyota", updatedCarResult.getBrand().getName());
        assertEquals("Corolla", updatedCarResult.getModel().getName());
    }

    @Test
    public void deleteCar_WithValidId_DeletesCar() {
        Long id = 1L;

        carService.deleteCar(id);

        verify(carRepository, times(1)).deleteById(id);
    }

}