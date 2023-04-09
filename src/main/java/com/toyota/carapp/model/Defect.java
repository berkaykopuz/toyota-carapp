package com.toyota.carapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="defects")
@Data
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
}
