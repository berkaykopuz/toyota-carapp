package com.toyota.carapp.repository;

import com.toyota.carapp.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByModelContaining(String model);
}
