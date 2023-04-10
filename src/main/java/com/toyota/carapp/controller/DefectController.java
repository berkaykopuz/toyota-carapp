package com.toyota.carapp.controller;

import com.toyota.carapp.dto.CreateDefectRequest;
import com.toyota.carapp.dto.DefectDto;
import com.toyota.carapp.dto.UpdateDefectRequest;
import com.toyota.carapp.service.DefectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DefectController {
    private DefectService defectService;
    @Autowired
    public DefectController(DefectService defectService) {
        this.defectService = defectService;
    }

    @GetMapping("defects")
    public ResponseEntity<List<DefectDto>> getAllDefects(){
        return new ResponseEntity<>(defectService.getAllDefects(), HttpStatus.OK);
    }

    @GetMapping("defects/{id}")
    public ResponseEntity<DefectDto> getDefectById(@PathVariable("id") Long defectId){
        return new ResponseEntity<>(defectService.getDefectById(defectId), HttpStatus.OK);
    }

    @PostMapping("defects/create")
    public ResponseEntity<DefectDto> createDefect(@RequestBody CreateDefectRequest request){
        return new ResponseEntity<>(defectService.createDefect(request), HttpStatus.OK);
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
