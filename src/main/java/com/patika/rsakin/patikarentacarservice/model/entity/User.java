package com.patika.rsakin.patikarentacarservice.model.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "USERS")
public class User extends BaseEntity {

    private String username;

    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car personalCar;

}