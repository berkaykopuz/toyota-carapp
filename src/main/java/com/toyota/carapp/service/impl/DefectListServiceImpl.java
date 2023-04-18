package com.toyota.carapp.service.impl;

import com.toyota.carapp.dto.DefectResponse;
import com.toyota.carapp.model.Defect;
import com.toyota.carapp.model.DefectLocation;
import com.toyota.carapp.repository.ListDefectRepository;
import com.toyota.carapp.service.DefectCreationService;
import com.toyota.carapp.service.DefectListService;
import com.toyota.carapp.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.stream.Location;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
@Service
@Transactional
public class DefectListServiceImpl implements DefectListService {
    private final ListDefectRepository repository;
    private final DefectCreationService creationService;
    private final LocationService locationService;
    @Autowired
    public DefectListServiceImpl(ListDefectRepository repository, DefectCreationService service,
                                 LocationService locationService) {
        this.repository = repository;
        this.creationService = service;
        this.locationService = locationService;
    }



    /*public DefectResponse getAllPointedImages(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        List<byte[]> pointedImages = new ArrayList<>();
        Page<Defect> defects = repository.findAll(pageable);
        List<Defect> listOfDefects = defects.getContent();
        listOfDefects.forEach((defect) ->{
            Set<DefectLocation> locations = defect.getLocations();
            locations.forEach((location) ->{
                        try {
                            defect.setImage(creationService.getPointedImage(defect.getId(),location.getId()));
                            pointedImages.add(defect.getImage());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
        });


        DefectResponse response = new DefectResponse();
        response.setPointedImages(pointedImages);
        response.setPageNo(defects.getNumber());
        response.setTotalElements(defects.getTotalElements());
        response.setTotalPages(defects.getTotalPages());
        response.setLast(defects.isLast());

        return response;
    }*/

}
