package com.toyota.carapp.service.impl;

import com.toyota.carapp.dto.CreateLocationRequest;
import com.toyota.carapp.dto.LocationDto;
import com.toyota.carapp.dto.LocationDtoConverter;
import com.toyota.carapp.exception.NotFoundException;
import com.toyota.carapp.model.Defect;
import com.toyota.carapp.model.DefectLocation;
import com.toyota.carapp.repository.LocationRepository;
import com.toyota.carapp.service.DefectService;
import com.toyota.carapp.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    private LocationRepository locationRepository;
    private LocationDtoConverter converter;
    private DefectService service;
    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository, LocationDtoConverter converter, DefectService service) {
        this.locationRepository = locationRepository;
        this.converter = converter;
        this.service = service;
    }

    @Override
    public List<LocationDto> getAllLocations() {
        return converter.convert(locationRepository.findAll());
    }


    @Override
    public LocationDto getLocationById(Long locationId) {
        DefectLocation location = locationRepository.findById(locationId).orElseThrow(()-> new NotFoundException("location didnt found."));
        return converter.convert(location);
    }

    @Override
    public LocationDto createLocation(CreateLocationRequest request) {
        Defect defect = service.findDefectById(request.getDefectId());

        DefectLocation location = new DefectLocation(
            request.getId(),
            request.getCoordinate_x(),
            request.getCoordinate_y(),
            defect
        );

        return converter.convert(locationRepository.save(location));
    }

    @Override
    public void deleteLocation(Long locationId) {
        locationRepository.deleteById(locationId);
    }
}
