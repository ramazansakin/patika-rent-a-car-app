package com.patika.rsakin.patikarentacarservice.model.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "CARS")
public class Car extends BaseEntity {

    private Car.Color color;

    private int km;

    private String plate;   // plaka

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    private Model model;

    public enum Color {
        RED,
        BLUE,
        WHITE,
        GREEN,
        AQUA
    }

}