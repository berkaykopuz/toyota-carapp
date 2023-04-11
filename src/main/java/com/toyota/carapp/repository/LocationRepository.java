package com.toyota.carapp.repository;

import com.toyota.carapp.model.DefectLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<DefectLocation, Long> {

}
