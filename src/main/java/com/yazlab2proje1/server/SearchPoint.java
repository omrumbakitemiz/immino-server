package com.yazlab2proje1.server;

import models.Trajectory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SearchPoint {

    @CrossOrigin
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ResponseEntity<List<Trajectory>> search(
            @RequestParam("nwLat") Double nwLat,
            @RequestParam("nwLng") Double nwLng,
            @RequestParam("seLat") Double seLat,
            @RequestParam("seLng") Double seLng,
            @RequestBody List<Trajectory> allCoordinates) {

        List<Trajectory> insideCoordinates = new ArrayList<>();

        // lng sınırları nwlng - selng
        // ltd sınırları nwlat - selat

        for(Trajectory coordinate : allCoordinates) {
            boolean inside = false;

            // AĞLAMAK İSTİYORUM BU NASIL KOD
            // KENDİMİ KINIYORUM
            // BİR AN ÖNCE ŞU KODU DÜZELT
            // DÜZELTMEZSEN ÜÇ VAKTE KADAR BİLGİSAYARIN BOZULUR İNŞ

            // lng - lat kontrolü
            Double lng = coordinate.getLng();
            Double lat = coordinate.getLat();

            Double minLat = nwLat;
            Double maxLat = seLat;
            Double minLng = nwLng;
            Double maxLng = seLng;

            if(nwLat > seLat) {
                maxLat = nwLat;
                minLat = seLat;
            }
            if(nwLng > seLng) {
                maxLng = nwLng;
                minLng = seLng;
            }

            if(lng >= minLng && lng <= maxLng && lat >= minLat && lat <= maxLat) {
                inside = true;
            }

            if (inside) {
                insideCoordinates.add(coordinate);
            }
        }

        return new ResponseEntity<>(insideCoordinates, HttpStatus.OK);
    }
}
