package com.toyota.carapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.awt.*;
@AllArgsConstructor
@Data
public class LocationDto {
    private Long id;
    private Double coordinate_x;
    private Double coordinate_y;

}
