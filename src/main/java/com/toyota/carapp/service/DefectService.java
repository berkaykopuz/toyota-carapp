package com.toyota.carapp.service;

import com.toyota.carapp.dto.DefectDto;
import com.toyota.carapp.dto.UpdateDefectRequest;
import com.toyota.carapp.model.Defect;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;


public interface DefectService {
    List<DefectDto> getAllDefects();
    byte[] getDefectById(Long defectId);
    String createDefect(String type, Long vehicleId , MultipartFile file) throws IOException;
    DefectDto updateDefect(UpdateDefectRequest request, Long defectId);
    void deleteDefect(Long defectId);
    Defect findDefectById(Long defectId);
}
