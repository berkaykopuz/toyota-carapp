package com.toyota.carapp.service;

import com.toyota.carapp.dto.CreateDefectRequest;
import com.toyota.carapp.dto.DefectDto;
import com.toyota.carapp.dto.UpdateDefectRequest;
import com.toyota.carapp.model.Defect;


import java.util.List;

public interface DefectService {
    List<DefectDto> getAllDefects();
    DefectDto getDefectById(Long defectId);
    DefectDto createDefect(CreateDefectRequest request);
    DefectDto updateDefect(UpdateDefectRequest request, Long defectId);
    void deleteDefect(Long defectId);
    Defect findDefectById(Long defectId);
}
