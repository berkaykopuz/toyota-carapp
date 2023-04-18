package com.toyota.carapp.controller;

import com.toyota.carapp.dto.DefectResponse;
import com.toyota.carapp.model.Defect;
import com.toyota.carapp.service.DefectCreationService;
import com.toyota.carapp.service.DefectListService;
import com.toyota.carapp.service.DefectService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DefectListController {
    private DefectListService service;
    private DefectService defectService;
    private DefectCreationService creationService;

    @Autowired
    public DefectListController(DefectListService service, DefectCreationService creationService) {
        this.service = service;
        this.creationService = creationService;
    }

    @GetMapping("defect/defect-image/{id}")
    public ResponseEntity<byte[]> getPointedImage(@PathVariable("id") Long defectId) throws IOException {
        byte[] image = creationService.getPointedImage(defectId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(image);
    }


}
