package com.toyota.carapp.controller;


import com.toyota.carapp.dto.DefectDto;
import com.toyota.carapp.dto.UpdateDefectRequest;
import com.toyota.carapp.model.Defect;
import com.toyota.carapp.service.DefectCreationService;
import com.toyota.carapp.service.DefectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DefectController {
    private DefectService defectService;
    private DefectCreationService creationService;
    @Autowired
    public DefectController(DefectService defectService, DefectCreationService creationService) {
        this.defectService = defectService;
        this.creationService = creationService;
    }

    @GetMapping("defects")
    public ResponseEntity<List<DefectDto>> getAllDefects(){
        return new ResponseEntity<>(defectService.getAllDefects(), HttpStatus.OK);
    }

    @GetMapping("defects/{id}")
    public ResponseEntity<DefectDto> getDefectById(@PathVariable("id") Long defectId){
        return new ResponseEntity<>(defectService.getDefectById(defectId),HttpStatus.OK);
    }

    @PostMapping("defects/create")
    public ResponseEntity<String> createDefect(@RequestParam("type") String type,
                                                  @RequestParam("vehicleId") Long vehicleId,
                                                  @RequestParam("image")MultipartFile file) throws IOException {
        return new ResponseEntity<>(defectService.createDefect(type,vehicleId,file), HttpStatus.CREATED);
    }

    @PutMapping("defects/{id}/update")
    public ResponseEntity<DefectDto> updateDefect(@RequestBody UpdateDefectRequest request,
                                                  @PathVariable("id") Long defectId){
        return new ResponseEntity<>(defectService.updateDefect(request,defectId),HttpStatus.OK);
    }

    @DeleteMapping("defects/{id}/delete")
    public ResponseEntity<String> deleteDefect(@PathVariable("id") Long defectId){
        defectService.deleteDefect(defectId);
        return new ResponseEntity<>("Defect has deleted", HttpStatus.OK);
    }

}
