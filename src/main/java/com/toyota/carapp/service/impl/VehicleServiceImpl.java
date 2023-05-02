package com.toyota.carapp.service.impl;

import com.toyota.carapp.dto.VehicleDto;
import com.toyota.carapp.dto.VehicleDtoConverter;
import com.toyota.carapp.exception.NotFoundException;
import com.toyota.carapp.model.Vehicle;
import com.toyota.carapp.repository.VehicleRepository;
import com.toyota.carapp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;

    private VehicleDtoConverter converter;
    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository,
                              VehicleDtoConverter converter
                              ) {
        this.vehicleRepository = vehicleRepository;
        this.converter = converter;

    }

    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle(vehicleDto.getId(),
                vehicleDto.getModel(),
                vehicleDto.getColor(),
                vehicleDto.getProductionDate()
                );

        return converter.convert(vehicleRepository.save(vehicle));
    }

    @Override
    public List<VehicleDto> getAllVehicles() {
        return converter.convert(vehicleRepository.findAll());
    }

    @Override
    public VehicleDto getVehicleById(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(()-> new NotFoundException("vehicle didnt found."));
        return converter.convert(vehicle);
    }

    @Override
    public VehicleDto updateVehicle(VehicleDto vehicleDto, Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(()-> new NotFoundException("vehicle didnt found."));

            Vehicle updatedVehicle = new Vehicle(
                    vehicle.getId(),
                    vehicleDto.getModel(),
                    vehicleDto.getColor(),
                    vehicleDto.getProductionDate()
            );

        return converter.convert(vehicleRepository.save(updatedVehicle));
    }

    @Override
    public void deleteVehicle(Long vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }

    @Override
    public Vehicle findVehicleById(Long vehicleId) {

        return vehicleRepository.findById(vehicleId).orElseThrow(()-> new NotFoundException("vehicle didnt found."));
    }

}
