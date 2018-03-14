package utils.seriesreducer;

import java.util.Arrays;
import java.util.List;

public class Line<P extends Point> {
    
    private P start;
    private P end;
    
    private double dx;
    private double dy;
    private double sxey;
    private double exsy;
    private  double length;
    
    public Line(P start, P end) {
        this.start = start;
        this.end = end;
        dx = start.getLat() - end.getLat();
        dy = start.getLng() - end.getLng();
        sxey = start.getLat() * end.getLng();
        exsy = end.getLat() * start.getLng();
        length = Math.sqrt(dx*dx + dy*dy);
    }
    
    @SuppressWarnings("unchecked")
    public List<P> asList() {
        return Arrays.asList(start, end);
    }
    
    double distance(P p) {
        return Math.abs(dy * p.getLat() - dx * p.getLng() + sxey - exsy) / length;
    }
}


