package com.yazlab2proje1.server;

import models.Coordinate;
import models.Trajectory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utils.seriesreducer.Point;
import utils.seriesreducer.SeriesReducer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DataSampling {

    @CrossOrigin
    @RequestMapping(value = "/simplify", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Trajectory>> getReducedData(@RequestBody List<Trajectory> coordinates) {

        List<Trajectory> response = new ArrayList<>();

        for (int i = 0; i < coordinates.size(); i++){
            if(i % 10 == 0) {
                response.add(coordinates.get(i));
            }
        }

        return ResponseEntity.ok(response);
    }

    @CrossOrigin
    @RequestMapping(value = "/ramer", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Point>> getSimplifiedData(
            @RequestBody List<Trajectory> coordinates, @RequestParam("epsilon") Double epsilon) {

        List<Point> points = new ArrayList<>();

        for (Trajectory coordinate : coordinates) {
            Double lat = coordinate.getLat();
            Double lng = coordinate.getLng();

            points.add(new Coordinate(lat, lng));
        }

        List<Point> reduced = SeriesReducer.reduce(points, epsilon);

        return ResponseEntity.ok(reduced);
    }
}
