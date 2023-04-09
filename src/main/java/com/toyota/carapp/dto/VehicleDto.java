package com.toyota.carapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class VehicleDto {
    private Long id;

    private String model;

    private String color;

    private String productionDate;

    private List<DefectDto> defectDtos;


}
