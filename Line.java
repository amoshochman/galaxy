package galaxy;

public class Line {
	double slope;
	double yIntersection;
	public Line(Point a, Point b) {
		slope=(b.y-a.y)/(b.x-a.x);
		yIntersection=a.y-(slope*a.x);
	}
	public boolean equals(Object other) {
        if (!(other instanceof Line)) {
        	return false;
        }
        Line otherLine = (Line) other;
        return this.yIntersection==otherLine.yIntersection &&
        		this.slope==otherLine.slope;
    }	
}
