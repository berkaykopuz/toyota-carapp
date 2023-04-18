package com.toyota.carapp.service.impl;

import com.toyota.carapp.dto.DefectDto;
import com.toyota.carapp.dto.DefectDtoConverter;

import com.toyota.carapp.model.Defect;
import com.toyota.carapp.repository.ListDefectRepository;
import com.toyota.carapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DefectListServiceImpl implements DefectListService {
    private final ListDefectRepository repository;
    private final DefectDtoConverter converter;
    private final DefectCreationService creationService;
    private final LocationService locationService;
    private final VehicleService vehicleService;
    @Autowired
    public DefectListServiceImpl(ListDefectRepository repository, DefectDtoConverter converter, DefectCreationService service,
                                 DefectService defectService, LocationService locationService, VehicleService vehicleService) {
        this.repository = repository;
        this.converter = converter;
        this.creationService = service;
        this.locationService = locationService;
        this.vehicleService = vehicleService;
    }



    public Page<DefectDto> getAllDefects(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        /*List<DefectDto> defectDtos = converter.convert(repository.findAll());
        long total = defectDtos.size();

        Page<DefectDto> pages = new PageImpl<>(defectDtos,pageable,total);

        return pages;*/

        Page<Defect> defectPage = repository.findAll(pageable);

        Page<DefectDto> defectDtoPage  = defectPage.map(defect -> {
            DefectDto defectDto = converter.convert(defect);
            return defectDto;
        });

        return defectDtoPage;

    }
    public List<DefectDto> getAllSortedDefects(String sortBy, String sortOrder) {
        Sort sort = sortOrder.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();
        return converter.convert(repository.findAll(sort));
    }

    public List<DefectDto> findByTypeContaining(String type) {
        return converter.convert(repository.findByTypeContaining(type));
    }

}
