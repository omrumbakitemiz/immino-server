package com.yazlab2proje1.server;

import models.Trajectory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utilities {

    public List<Trajectory> getRandomLatLong() throws IOException {

        String workingDir = System.getProperty("user.dir");
        String path = workingDir + "/dataset.txt";

        File directory = new File(path);

        List<String> trajectoryList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(directory))) {
            String data;

            while((data = bufferedReader.readLine()) != null) {
                trajectoryList.add(data);
            }
        }

        List<Trajectory> coordinateList = new ArrayList<>();

        for(int i = 0; i < trajectoryList.size(); i++) {
            String tempData = trajectoryList.get(i);

            String[] coordinates = tempData.split(",");

            Trajectory trajectoryData = new Trajectory();

            trajectoryData.setLat(Double.parseDouble(coordinates[0]));
            trajectoryData.setLng(Double.parseDouble(coordinates[1]));

            coordinateList.add(trajectoryData);
        }

        return coordinateList;
    }
}
