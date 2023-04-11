package com.toyota.carapp.service;

import com.toyota.carapp.dto.CreateLocationRequest;
import com.toyota.carapp.dto.LocationDto;
import com.toyota.carapp.dto.UserDto;

import java.util.List;

public interface LocationService {
    List<LocationDto> getAllLocations();
    LocationDto getLocationById(Long locationId);
    LocationDto createLocation(CreateLocationRequest request);

    void deleteLocation(Long locationId);
}
