package com.toyota.carapp.dto;

import com.toyota.carapp.model.Defect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefectDtoConverter {
    private LocationDtoConverter converter;
    @Autowired
    public DefectDtoConverter(LocationDtoConverter converter) {
        this.converter = converter;
    }

    public DefectDto convert(Defect defect){
        return new DefectDto(defect.getId(),
                defect.getType(),
                defect.getDate(),
                converter.convert(new ArrayList<>(defect.getLocations())));
    }
    public List<DefectDto> convert(List<Defect> defectList){
        return defectList
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());

    }
}
