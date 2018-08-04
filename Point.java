package galaxy;

public class Point {

	protected double x;
	protected double y;
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public Point(double x, double y) {
		this.x=x;
		this.y=y;
	}
	public static double getTriangleArea(Point a, Point b, Point c) {
		return Math.abs((c.x*(a.y-b.y)+a.x*(b.y-c.y)+b.x*(c.y-a.y))/2);
	}
	public double getDistanceTo(Point other) {
		return Math.sqrt(Math.pow(other.x-this.x, 2)+Math.pow(other.y-this.y, 2));
	}
	
	public boolean equals(Object other) {
        if (!(other instanceof Point)) {
        	return false;
        }
        Point otherPoint = (Point) other;
        return this.x==otherPoint.x && this.y==otherPoint.y;
    }	
}
