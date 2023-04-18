package com.toyota.carapp.service;

import java.io.IOException;

public interface DefectCreationService {
    byte[] getImageById(Long defectId);
    byte[] getPointedImage(Long defectId) throws IOException;
}
