package io.imminoserver.utils.seriesreducer;

import java.util.Arrays;
import java.util.List;

public class Line<P extends Point> {

    private final P start;
    private final P end;

    private final double dx;
    private final double dy;
    private final double sxey;
    private final double exsy;
    private final double length;

    Line(P start, P end) {
        this.start = start;
        this.end = end;
        dx = start.getLat() - end.getLat();
        dy = start.getLng() - end.getLng();
        sxey = start.getLat() * end.getLng();
        exsy = end.getLat() * start.getLng();
        length = Math.sqrt(dx * dx + dy * dy);
    }

    public List<P> asList() {
        return Arrays.asList(start, end);
    }

    double distance(P p) {
        return Math.abs(dy * p.getLat() - dx * p.getLng() + sxey - exsy) / length;
    }
}


