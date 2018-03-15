package com.yazlab2proje1.server;

import models.Trajectory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class Coordinates {

    @CrossOrigin
    @RequestMapping("/")
    public List<Trajectory> GetRandomLatLong() throws Exception {
        Utilities utilities = new Utilities();
        List<Trajectory> result = utilities.getRandomLatLong();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println("data sended from random: " + LocalDateTime.now().format(formatter));

        return result;
    }
}
