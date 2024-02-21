package com.patika.rsakin.patikarentacarservice.model.dto;

import lombok.Data;

@Data
public class CarDTO {

    private Long id;
    private String color;
    private int km;
    private String plate;
    private String brandName;
    private String modelName;

}