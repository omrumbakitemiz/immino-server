package com.yazlab2proje1.server;

import models.Trajectory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DataSampling {

    @CrossOrigin
    @RequestMapping(value = "/simplify", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Trajectory>> GetReducedData(@RequestBody List<Trajectory> coordinates) {

        List<Trajectory> response = new ArrayList<>();

        // int length = 1;
        // if(coordinates.size() / 10 > 1) {
        //     length = coordinates.size() / 10;
        // }

        for (int i = 0; i < coordinates.size(); i++){
            if(i % 10 == 0) {
                response.add(coordinates.get(i));
            }
        }

        return ResponseEntity.ok(response);
    }
}
