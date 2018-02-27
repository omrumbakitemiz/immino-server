package com.yazlab2proje1.server;

import Models.Trajectory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5000")
@RestController
public class Coordinates {

    @RequestMapping("/getRandomCoordinates")
    public List<Trajectory> GetRandomLatLong() throws Exception {
        Utilities utilities = new Utilities();
        List<Trajectory> result = utilities.GetRandomLatLong();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println("data sended from random: " + LocalDateTime.now().format(formatter));

        return result;
    }
}
