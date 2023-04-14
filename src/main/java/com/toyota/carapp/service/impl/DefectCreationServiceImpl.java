package com.toyota.carapp.service.impl;

import com.toyota.carapp.dto.LocationDto;
import com.toyota.carapp.service.DefectCreationService;
import com.toyota.carapp.service.DefectService;
import com.toyota.carapp.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@Service
public class DefectCreationServiceImpl implements DefectCreationService {
    private DefectService defectService;
    private LocationService locationService;
    @Autowired
    public DefectCreationServiceImpl(DefectService defectService, LocationService locationService) {
        this.defectService = defectService;
        this.locationService = locationService;
    }
    public byte[] getPointedImage(Long defectId, Long locationId) throws IOException {
        LocationDto locationDto = locationService.getLocationById(locationId);
        int x,y;
        x = locationDto.getCoordinate_x().intValue();
        y = locationDto.getCoordinate_y().intValue();

        byte[] readyImage = defectService.getDefectById(defectId);
        Image image = ImageIO.read(new ByteArrayInputStream(readyImage));
        BufferedImage bi = new BufferedImage(1000,1000,BufferedImage.TYPE_3BYTE_BGR);
        //point into photo
        Graphics2D graphics2D = bi.createGraphics ();
        graphics2D.drawImage(image, 0, 0, 1000, 1000, null);
        graphics2D.setPaint ( Color.WHITE );
        graphics2D.fillRect ( x,y,50,50 );
        graphics2D.setPaint ( Color.BLACK );
        graphics2D.drawOval ( x, y, 50, 50 );
        graphics2D.dispose ();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, "jpg", baos);
        readyImage = baos.toByteArray();

        return readyImage;
    }

}
