package com.patika.rsakin.patikarentacarservice.model.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User extends BaseEntity {

    private String username;
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car personalCar;

}