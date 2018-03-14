package models;

import utils.seriesreducer.Point;

public class Coordinate implements Point {

    public Coordinate(Double x, Double y) {
        this.lat = x;
        this.lng = y;
    }

    private Double lat;
    private Double lng;

    @Override
    public double getLat() {
        return lat;
    }

    @Override
    public double getLng() {
        return lng;
    }
}
