package com.yazlab2proje1.server;

import Models.Trajectory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Utilities {

    public List<Trajectory> GetRandomLatLong() throws Exception {

        String workingDir = System.getProperty("user.dir");
        String path = workingDir + "/file2.plt";

        File directory = new File(path);

        //File[] files = directory.listFiles();

        //Random random = new Random();

        //File file = files[random.nextInt(files.length)];

        BufferedReader bufferedReader = new BufferedReader(new FileReader(directory));

        List<String> trajectoryList = new ArrayList<>();

        String data;
        int counter = 1;

        while((data = bufferedReader.readLine()) != null) {
            // 7. satırdan sonra kaydetmeye başla
            if(counter >= 7) {
                trajectoryList.add(data);
            }
            counter++;
        }

        bufferedReader.close();

        List<Trajectory> coordinateList = new ArrayList<>();

        for(int i = 0; i < trajectoryList.size(); i++) {
            String tempData = trajectoryList.get(i);

            String[] coordinates = tempData.split(",");

            Trajectory trajectoryData = new Trajectory();

            trajectoryData.lat = Double.parseDouble(coordinates[0]);
            trajectoryData.lng = Double.parseDouble(coordinates[1]);

            coordinateList.add(trajectoryData);
        }

        return coordinateList;
    }
}
