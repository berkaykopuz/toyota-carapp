package com.toyota.carapp.controller;

import com.toyota.carapp.dto.DefectDto;
import com.toyota.carapp.service.DefectCreationService;
import com.toyota.carapp.service.DefectListService;
import com.toyota.carapp.service.DefectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api")
public class DefectListController {
    private DefectListService defectListService;
    private DefectService defectService;
    private DefectCreationService creationService;

    @Autowired
    public DefectListController(DefectListService service, DefectCreationService creationService) {
        this.defectListService = service;
        this.creationService = creationService;
    }

    @GetMapping("defects/defect-image/{id}")
    public ResponseEntity<byte[]> getPointedImage(@PathVariable("id") Long defectId) throws IOException {
        byte[] image = creationService.getPointedImage(defectId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<DefectDto>> getAllPaged(@RequestParam(value="pageNo",defaultValue = "0",required = false) int pageNo,
                                                       @RequestParam(value="pageSize",defaultValue = "1",required = false) int pageSize) {
        return new ResponseEntity<>(defectListService.getAllDefects(pageNo, pageSize),HttpStatus.OK);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<DefectDto>> getAllSorted(@RequestParam String sortBy, @RequestParam String sortOrder) {
        return ResponseEntity.ok(defectListService.getAllSortedDefects(sortBy, sortOrder));
    }

    @GetMapping("/search")
    public ResponseEntity<List<DefectDto>> searchByType(@RequestParam(value = "type") String type) {
        return ResponseEntity.ok(defectListService.findByTypeContaining(type));
    }


}
