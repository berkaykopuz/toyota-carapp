package com.toyota.carapp.repository;

import com.toyota.carapp.model.Defect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DefectRepository extends JpaRepository<Defect, Long> {
}
