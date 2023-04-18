package com.toyota.carapp.service.impl;

import com.toyota.carapp.model.Defect;
import com.toyota.carapp.model.DefectLocation;
import com.toyota.carapp.repository.DefectRepository;
import com.toyota.carapp.service.DefectCreationService;
import com.toyota.carapp.service.DefectService;
import com.toyota.carapp.service.LocationService;
import com.toyota.carapp.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Transactional
public class DefectCreationServiceImpl implements DefectCreationService {
    private DefectRepository defectRepository;
    private DefectService defectService;
    private LocationService locationService;
    @Autowired
    public DefectCreationServiceImpl(DefectService defectService,
                                     LocationService locationService, DefectRepository defectRepository) {
        this.defectService = defectService;
        this.locationService = locationService;
        this.defectRepository = defectRepository;
    }
    @Override
    public byte[] getImageById(Long defectId){
        Defect defect = defectRepository.findById(defectId).orElseThrow(null);
        byte[] image = ImageUtils.decompressImage(defect.getImage());
        return image;
    }
    public byte[] getPointedImage(Long defectId) throws IOException {
        Defect defect = defectService.findDefectById(defectId);
        Set<DefectLocation> defectLocations = defect.getLocations();
        AtomicInteger x = new AtomicInteger();
        AtomicInteger y = new AtomicInteger();

        byte[] readyImage = getImageById(defectId);
        Image[] image = {ImageIO.read(new ByteArrayInputStream(readyImage))};
        BufferedImage bi = new BufferedImage(1000,1000,BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graphics2D = bi.createGraphics ();


        defectLocations.forEach(location -> {

            x.set(location.getCoordinate_x().intValue());
            y.set(location.getCoordinate_y().intValue());

            graphics2D.drawImage(image[0], 0, 0, 1000, 1000, null);
            graphics2D.setPaint ( Color.WHITE );
            graphics2D.fillRect (x.get(),y.get(),50,50 );
            graphics2D.setPaint ( Color.BLACK );
            graphics2D.drawOval (x.get(), y.get(), 50, 50 );

            image[0] = bi;
        }

        );


        graphics2D.dispose ();
        //point into photo


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, "jpg", baos);
        readyImage = baos.toByteArray();

        return readyImage;
    }

}
