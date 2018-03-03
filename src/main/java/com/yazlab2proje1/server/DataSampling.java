package com.yazlab2proje1.server;

import Models.Trajectory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DataSampling {

    @CrossOrigin
    @RequestMapping(value = "/getReducedData", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> GetReducedData(@RequestBody List<Trajectory> coordinates) {

        System.out.println("Latitude: " + coordinates.get(0).Latitude + "\n");
        System.out.println("Longitude: " + coordinates.get(0).Longitude);

        String response = (coordinates.get(0).Latitude.toString() + " " + coordinates.get(0).Longitude.toString());

        return ResponseEntity.ok(response);
    }
}
