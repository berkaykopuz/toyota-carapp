package com.toyota.carapp.dto;

import lombok.Data;

import java.awt.*;
@Data
public class CreateLocationRequest {
    private Long id;
    private Double coordinate_x;
    private Double coordinate_y;
    private Long defectId;
}
