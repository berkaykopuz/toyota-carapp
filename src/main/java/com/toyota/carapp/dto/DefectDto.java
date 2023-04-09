package com.toyota.carapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;



import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Data
public class DefectDto {
    private Long id;

    private String type;

    private Date date;

    private List<LocationDto> locations;
}
