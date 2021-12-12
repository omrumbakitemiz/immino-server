package io.imminoserver.controllers;

import io.imminoserver.models.Coordinate;
import io.imminoserver.models.Trajectory;
import io.imminoserver.utils.seriesreducer.Point;
import io.imminoserver.utils.seriesreducer.SeriesReducer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DataSamplingController {

    @CrossOrigin
    @RequestMapping(value = "/simplify", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Trajectory>> getReducedData(@RequestBody List<Trajectory> coordinates) {

        List<Trajectory> response = new ArrayList<>();

        for (int i = 0; i < coordinates.size(); i++) {
            if (i % 10 == 0) {
                response.add(coordinates.get(i));
            }
        }

        return ResponseEntity.ok(response);
    }

    @CrossOrigin(exposedHeaders = "reduceTime")
    @RequestMapping(value = "/ramer", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Point>> getSimplifiedData(
            @RequestBody List<Trajectory> coordinates,
            @RequestParam("epsilon") Double epsilon) {

        List<Point> points = new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();

        long startTime;
        long endTime;
        long duration;

        for (Trajectory coordinate : coordinates) {
            Double lat = coordinate.getLat();
            Double lng = coordinate.getLng();

            points.add(new Coordinate(lat, lng));
        }

        startTime = System.nanoTime();

        List<Point> reduced = SeriesReducer.reduce(points, epsilon);

        endTime = System.nanoTime();

        duration = (endTime - startTime); //divide by 1000000 to get milliseconds

        headers.add("reduceTime", String.valueOf(duration));
        headers.getAccessControlExposeHeaders();

        return new ResponseEntity<>(reduced, headers, HttpStatus.OK);
    }
}
