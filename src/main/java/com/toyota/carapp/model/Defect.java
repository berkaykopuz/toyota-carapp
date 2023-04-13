package com.toyota.carapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="defects")
@Getter
@Setter
@NoArgsConstructor
public class Defect {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="type")
    private String type;

    @Lob
    @Column(name = "image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="vehicle_id", nullable = false)
    private Vehicle vehicle;

    @OneToMany(mappedBy = "defect",
    fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private Set<DefectLocation> locations = new HashSet<>();

    public Defect(String type, byte[] image, Vehicle vehicle) {

        this.type = type;
        this.image = image;
        this.vehicle = vehicle;
    }

    public Defect(Long id, String type, Vehicle vehicle) {
        this.id = id;
        this.type = type;
        this.vehicle = vehicle;
    }
}
