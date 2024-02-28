package com.patika.rsakin.patikarentacarservice.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "MODELS")
public class Model extends BaseEntity {

    private String name;

    @Column(name = "production_year")
    private String year;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Enumerated(EnumType.STRING)
    private GearType gearType;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;

    public Model(String modelName) {
        super();
        name = modelName;
    }

    public enum FuelType {
        GASOLINE,
        LPG,
        ELECTRIC,
        DIESEL
    }

    public enum GearType {
        MANUEL,
        AUTO
    }

    public enum Type {
        SEDAN,
        HATCHBACK,
        SUV,
        CROSSOVER,
        MINIVAN
    }

}