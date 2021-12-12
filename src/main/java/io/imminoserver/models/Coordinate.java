package io.imminoserver.models;

import io.imminoserver.utils.seriesreducer.Point;

public class Coordinate implements Point {

    private final Double lat;
    private final Double lng;

    public Coordinate(Double x, Double y) {
        this.lat = x;
        this.lng = y;
    }

    @Override
    public double getLat() {
        return lat;
    }

    @Override
    public double getLng() {
        return lng;
    }
}
