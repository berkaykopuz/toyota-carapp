package com.toyota.carapp.repository;

import com.toyota.carapp.model.Defect;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListDefectRepository extends JpaRepository<Defect,Long> {
    Page<Defect> findByTypeContaining(String type, Pageable pageable);
    List<Defect> findByTypeContaining(String type, Sort sort);
}
