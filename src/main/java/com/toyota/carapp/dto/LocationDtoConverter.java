package com.toyota.carapp.dto;

import com.toyota.carapp.model.Defect;
import com.toyota.carapp.model.DefectLocation;
import com.toyota.carapp.model.Vehicle;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocationDtoConverter {
    public LocationDto convert(DefectLocation location){
        return new LocationDto(location.getId(),location.getCoordinate_x(),location.getCoordinate_y());
    }
    public List<LocationDto> convert(List<DefectLocation> locationList){
        return locationList.stream().map(this::convert).collect(Collectors.toList());

    }
}
