package com.patika.rsakin.patikarentacarservice.model.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "BRANDS")
public class Brand extends BaseEntity {

    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Model> models;

    public Brand(String brandName) {
        super();
        name = brandName;
    }
}