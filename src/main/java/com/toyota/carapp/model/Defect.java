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

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name="registry_date")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="vehicle_id", nullable = false)
    private Vehicle vehicle;

    @OneToMany(mappedBy = "defect",
    fetch = FetchType.LAZY,
    cascade = CascadeType.ALL)
    private Set<DefectLocation> locations = new HashSet<>();

    public Defect(Long id, String type, Vehicle vehicle) {
        this.id = id;
        this.type = type;
        this.vehicle = vehicle;
    }
}
