package com.toyota.carapp.service;

import java.io.IOException;

public interface DefectCreationService {
    public byte[] getPointedImage(Long defectId, Long locationId) throws IOException;
}
