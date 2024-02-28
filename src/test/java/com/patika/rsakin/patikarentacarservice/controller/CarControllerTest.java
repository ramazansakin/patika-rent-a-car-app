package com.patika.rsakin.patikarentacarservice.controller;

import com.patika.rsakin.patikarentacarservice.model.dto.CarDTO;
import com.patika.rsakin.patikarentacarservice.model.entity.Brand;
import com.patika.rsakin.patikarentacarservice.model.entity.Car;
import com.patika.rsakin.patikarentacarservice.model.entity.Model;
import com.patika.rsakin.patikarentacarservice.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CarController.class)
@AutoConfigureMockMvc
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    public void getAllCars_ReturnsListOfCars() throws Exception {
        Car car1 = new Car();
        car1.setBrand(new Brand("Toyota"));
        car1.setModel(new Model("Camry"));

        Car car2 = new Car();
        car2.setBrand(new Brand("Honda"));
        car2.setModel(new Model("Accord"));

        List<Car> cars = Arrays.asList(car1, car2);

        when(carService.getAllCars()).thenReturn(cars);

        mockMvc.perform(get("/cars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].brand.name").value("Toyota"))
                .andExpect(jsonPath("$[1].brand.name").value("Honda"));
    }

    @Test
    public void getCarById_ReturnsCarById() throws Exception {
        Long id = 1L;
        Car car = new Car();
        car.setBrand(new Brand("Toyota"));
        car.setModel(new Model("Camry"));
        car.setId(id);

        when(carService.getCarById(id)).thenReturn(car);

        mockMvc.perform(get("/cars/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brand.name").value("Toyota"))
                .andExpect(jsonPath("$.model.name").value("Camry"));
    }

    @Test
    public void createCar_CreatesNewCar() throws Exception {
        CarDTO carDTO = new CarDTO();
        carDTO.setBrandName("Toyota");
        carDTO.setModelName("Camry");

        when(carService.createCar(any(CarDTO.class))).thenReturn(carDTO);

        mockMvc.perform(post("/cars")
                        .contentType("application/json")
                        .content("{ \"brandName\": \"Toyota\", \"modelName\": \"Camry\" }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandName").value("Toyota"))
                .andExpect(jsonPath("$.modelName").value("Camry"));
    }

    @Test
    public void updateCar_UpdatesExistingCar() throws Exception {
        Long id = 1L;

        Car updatedCar = new Car();
        updatedCar.setBrand(new Brand("Toyota"));
        updatedCar.setModel(new Model("Corolla"));
        updatedCar.setId(id);

        when(carService.updateCar(eq(id), any(Car.class))).thenReturn(updatedCar);

        mockMvc.perform(put("/cars/{id}", id)
                        .contentType("application/json")
                        .content("{ \"brandName\": \"Toyota\", \"modelName\": \"Corolla\" }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brand.name").value("Toyota"))
                .andExpect(jsonPath("$.model.name").value("Corolla"));
    }

    @Test
    public void deleteCar_DeletesCarById() throws Exception {
        Long id = 1L;

        mockMvc.perform(delete("/cars/{id}", id))
                .andExpect(status().isOk());

        verify(carService, times(1)).deleteCar(id);
    }

}