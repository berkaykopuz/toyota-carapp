package com.toyota.carapp.controller;

import com.toyota.carapp.dto.CreateLocationRequest;
import com.toyota.carapp.dto.LocationDto;
import com.toyota.carapp.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LocationController {
    private LocationService service;
    @Autowired
    public LocationController(LocationService service) {
        this.service = service;
    }

    @GetMapping("locations")
    public ResponseEntity<List<LocationDto>> getAllLocations(){
        return new ResponseEntity<>(service.getAllLocations(), HttpStatus.OK);
    }

    @PostMapping("locations/create")
    public ResponseEntity<LocationDto> createLocation(@RequestBody CreateLocationRequest request){
        return new ResponseEntity<>(service.createLocation(request),HttpStatus.OK);
    }

    @DeleteMapping("locations/{id}/delete")
    public ResponseEntity<String> deleteLocation(@PathVariable("id") Long locationId){
        return new ResponseEntity<>("location has deleted", HttpStatus.OK);
    }
}
