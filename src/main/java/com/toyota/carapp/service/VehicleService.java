package com.toyota.carapp.service;

import com.toyota.carapp.dto.VehicleDto;
import com.toyota.carapp.model.Vehicle;


import java.util.List;
import java.util.Optional;

public interface VehicleService {
    VehicleDto createVehicle(VehicleDto vehicleDto);
    List<VehicleDto> getAllVehicles();

    VehicleDto getVehicleById(Long vehicleId);
    VehicleDto updateVehicle(VehicleDto vehicleDto, Long vehicleId);

    void deleteVehicle(Long vehicleId);
    Vehicle findVehicleById(Long vehicleId);
}
