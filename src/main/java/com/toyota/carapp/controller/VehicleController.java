package com.toyota.carapp.controller;


import com.toyota.carapp.dto.VehicleDto;
import com.toyota.carapp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VehicleController {
    private VehicleService vehicleService;
    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @GetMapping("vehicles")
    public ResponseEntity<List<VehicleDto>> getAllVehicles(){
        return new ResponseEntity<>(vehicleService.getAllVehicles(), HttpStatus.OK);
    }


    @GetMapping("vehicles/{id}")
    public ResponseEntity<VehicleDto> getVehiclesById(@PathVariable("id") Long vehicleId){
        return new ResponseEntity<>(vehicleService.getVehicleById(vehicleId), HttpStatus.OK);
    }


    @PostMapping("vehicles/create")
    public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(vehicleService.createVehicle(vehicleDto),HttpStatus.OK);
    }


    @PutMapping("vehicles/{id}/update")
    public ResponseEntity<VehicleDto> updateVehicle(@PathVariable("id") Long vehicleId,@RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(vehicleService.updateVehicle(vehicleDto,vehicleId), HttpStatus.OK);
    }


    @DeleteMapping("vehicles/{id}/delete")
    public ResponseEntity<String> deleteVehicle(@PathVariable("id") Long vehicleId){
        vehicleService.deleteVehicle(vehicleId);
        return new ResponseEntity<>("Vehicle has deleted",HttpStatus.OK);
    }


}
