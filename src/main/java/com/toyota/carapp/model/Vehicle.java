package com.toyota.carapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="vehicles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="model",nullable = false)
    private String model;

    @Column(name="color")
    private String color;

    @Column(name="production_date", nullable=false)
    private String productionDate;

    @OneToMany(mappedBy = "vehicle",
    fetch=FetchType.LAZY,
    cascade = CascadeType.ALL)
    private Set<Defect> defects = new HashSet<>();

    //instead of other args parameter. for dto converter
    public Vehicle(Long id, String model, String color, String productionDate) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.productionDate = productionDate;
    }
}
