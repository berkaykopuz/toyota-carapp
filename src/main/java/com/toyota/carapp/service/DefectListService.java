package com.toyota.carapp.service;

import com.toyota.carapp.dto.DefectDto;
import com.toyota.carapp.dto.VehicleDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface DefectListService {
    public Page<DefectDto> getAllDefects(int pageNo, int pageSize);

    public List<DefectDto> getAllSortedDefects(String sortBy, String sortOrder);

    public List<DefectDto> findByTypeContaining(String type);

    public List<DefectDto> findByVehicleId(Long vehicleId);

    public List<VehicleDto> findByVehicle(String model);

}
