package com.patika.rsakin.patikarentacarservice.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "BOOKING")
public class Booking extends BaseEntity {

    private String name;
    private String idno;
    private String mpno;
    private String mail;
    private int price;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "finish_date")
    private LocalDate finishDate;

//    Naming Convention
//    "finish-date" -> kebab-case
//    "finish_date" -> snake_case
//    "finishDate"  -> cameCase
//    "FinishDate"  -> PascalCase

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

}
