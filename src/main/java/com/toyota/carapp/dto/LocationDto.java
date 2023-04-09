package com.toyota.carapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.awt.*;
@AllArgsConstructor
@Data
public class LocationDto {
    private Long id;
    private Point coordinate_x;
    private Point coordinate_y;

}
