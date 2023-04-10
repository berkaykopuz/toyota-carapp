package com.toyota.carapp.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateDefectRequest {
    private Long id;

    private String type;

    private Date date;

}
