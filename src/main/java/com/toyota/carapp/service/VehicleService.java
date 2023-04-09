package com.toyota.carapp.service;

import com.toyota.carapp.dto.UserDto;
import com.toyota.carapp.dto.VehicleDto;

import java.util.List;

public interface VehicleService {
    VehicleDto createVehicle(VehicleDto vehicleDto);
    List<VehicleDto> getAllVehicles();

    VehicleDto getVehicleById(Long vehicleId);
    VehicleDto updateVehicle(VehicleDto vehicleDto, Long vehicleId);

    void deleteVehicle(Long vehicleId);
}
