package com.toyota.carapp.service.impl;

import com.toyota.carapp.dto.VehicleDto;
import com.toyota.carapp.dto.VehicleDtoConverter;
import com.toyota.carapp.model.Vehicle;
import com.toyota.carapp.repository.VehicleRepository;
import com.toyota.carapp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    private VehicleDtoConverter vehicleDtoConverter;
    private VehicleRepository vehicleRepository;
    private PasswordEncoder passwordEncoder;
    private VehicleDtoConverter converter;
    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository,
                              PasswordEncoder passwordEncoder, VehicleDtoConverter converter,
                              VehicleDtoConverter vehicleDtoConverter) {
        this.vehicleRepository = vehicleRepository;
        this.passwordEncoder = passwordEncoder;
        this.converter = converter;
        this.vehicleDtoConverter = vehicleDtoConverter;
    }

    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle(vehicleDto.getId(),
                vehicleDto.getModel(),
                vehicleDto.getColor(),
                vehicleDto.getProductionDate()
                );

        return vehicleDtoConverter.convert(vehicle);
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        return vehicleDtoConverter.convert(vehicleRepository.findAll());
    }

    @Override
    public VehicleDto getVehicleById(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(null);
        return vehicleDtoConverter.convert(vehicle);
    }

    @Override
    public VehicleDto updateVehicle(VehicleDto vehicleDto, Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(null);

            Vehicle updatedVehicle = new Vehicle(
                    vehicleDto.getId(),
                    vehicleDto.getModel(),
                    vehicle.getColor(),
                    vehicle.getProductionDate()
            );

        return vehicleDtoConverter.convert(vehicleRepository.save(updatedVehicle));
    }

    @Override
    public void deleteVehicle(Long vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }

}
