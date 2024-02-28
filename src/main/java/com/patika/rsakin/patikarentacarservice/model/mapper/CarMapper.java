package com.patika.rsakin.patikarentacarservice.model.mapper;

import com.patika.rsakin.patikarentacarservice.model.dto.CarDTO;
import com.patika.rsakin.patikarentacarservice.model.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CarMapper {

    @Mapping(source = "brandName", target = "brand.name")
    @Mapping(source = "modelName", target = "model.name")
    Car toEntity(CarDTO carDTO);

    @Mapping(source = "brand.name", target = "brandName")
    @Mapping(source = "model.name", target = "modelName")
    CarDTO toDTO(Car car);

}