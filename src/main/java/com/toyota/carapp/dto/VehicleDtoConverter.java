package com.toyota.carapp.dto;

import com.toyota.carapp.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class VehicleDtoConverter {
    private DefectDtoConverter converter;
    @Autowired
    public VehicleDtoConverter(DefectDtoConverter converter) {
        this.converter = converter;
    }

    public VehicleDto convert(Vehicle vehicle){
        return new VehicleDto(vehicle.getId(),
                vehicle.getModel(),
                vehicle.getProductionDate(),
                vehicle.getColor(),
                converter.convert(new ArrayList<>(vehicle.getDefects())));
    }
    public List<VehicleDto> convert(List<Vehicle> vehicleList){
        return vehicleList.stream().map(this::convert).collect(Collectors.toList());
    }

}
