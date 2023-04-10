package com.toyota.carapp.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class CreateDefectRequest {
    private Long id;

    private String type;

    private Date date;

    private Long vehicleId;
}
