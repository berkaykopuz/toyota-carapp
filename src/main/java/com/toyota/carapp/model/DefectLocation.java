package com.toyota.carapp.model;

import lombok.Data;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name="defect_locations")
@Data
public class DefectLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="X",nullable=false)
    private Point coordinate_x;

    @Column(name="Y",nullable=false)
    private Point coordinate_y;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="defect_id", nullable = false)
    private Defect defect;
}
