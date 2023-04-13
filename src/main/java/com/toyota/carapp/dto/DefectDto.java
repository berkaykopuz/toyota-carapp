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

    private byte[] image;

    private List<LocationDto> locations;

    public DefectDto(Long id, String type, List<LocationDto> locations) {
        this.id = id;
        this.type = type;
        this.locations = locations;
    }
}
