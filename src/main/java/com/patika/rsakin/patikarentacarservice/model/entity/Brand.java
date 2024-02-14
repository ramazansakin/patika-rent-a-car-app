package com.patika.rsakin.patikarentacarservice.model.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "BRANDS")
public class Brand extends BaseEntity {

    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Model> models;

}