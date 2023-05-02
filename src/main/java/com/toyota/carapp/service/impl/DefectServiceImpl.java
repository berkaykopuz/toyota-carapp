package com.toyota.carapp.service.impl;

import com.toyota.carapp.dto.DefectDto;
import com.toyota.carapp.dto.DefectDtoConverter;
import com.toyota.carapp.dto.UpdateDefectRequest;
import com.toyota.carapp.exception.NotFoundException;
import com.toyota.carapp.model.Defect;
import com.toyota.carapp.model.Vehicle;
import com.toyota.carapp.repository.DefectRepository;
import com.toyota.carapp.service.DefectService;
import com.toyota.carapp.service.VehicleService;
import com.toyota.carapp.util.ImageUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class DefectServiceImpl implements DefectService {
    private DefectRepository defectRepository;
    private VehicleService vehicleService;
    private DefectDtoConverter converter;

    public DefectServiceImpl(DefectRepository defectRepository, VehicleService vehicleService, DefectDtoConverter converter) {
        this.defectRepository = defectRepository;
        this.vehicleService = vehicleService;
        this.converter = converter;
    }

    @Override
    public List<DefectDto> getAllDefects() {

        return converter.convert(defectRepository.findAll());
    }

    @Override
    public DefectDto getDefectById(Long defectId){
        Defect defect = defectRepository.findById(defectId).orElseThrow(null);
        return converter.convert(defect);
    }

    @Override
    public String createDefect(String type, Long vehicleId , MultipartFile file) throws IOException{
        Vehicle vehicle = vehicleService.findVehicleById(vehicleId);
        Defect defect = new Defect(type,
                ImageUtils.compressImage(file.getBytes()),
                vehicle);
        if(defect != null){
            defectRepository.save(defect);
            return "defect created succesfully! defect type:" + type;
        }
        return null;
    }

    @Override
    public DefectDto updateDefect(UpdateDefectRequest request, Long defectId) {
        Vehicle vehicle = vehicleService.findVehicleById(defectId); //or else exception must be required here.

        Defect defect = new Defect(request.getId(),
                request.getType(),
                vehicle);
        return converter.convert(defectRepository.save(defect));
    }

    @Override
    public void deleteDefect(Long defectId) {
        defectRepository.deleteById(defectId);
    }

    @Override
    public Defect findDefectById(Long defectId) {

        return defectRepository.findById(defectId).orElseThrow(()-> new NotFoundException("defect didnt found."));
    }
}
