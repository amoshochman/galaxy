package galaxy;

/*A class for Astronomic objects in the galaxy*/
public class AstrObject{ 
	
	//protected double x, y, distanceToSun;
	protected double distanceToSun;
	String name;
	Point pos;
	public AstrObject(double x, double y, String name) {
		this.pos=new Point(x,y);
		/*We don't need to store the distance to sun in order to make the 
		calculations, as it's given by X and Y.
		We store it anyway to save time calculation on dayMove().*/
		distanceToSun=Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
		this.name=name;
	}
	
	public static boolean areInOneLine(AstrObject a, AstrObject b, AstrObject c) {
		Line ab=getLine(a,b); 
		Line bc=getLine(b,c); 
		return ab.equals(bc);
	}
	
	public static double getTrianglePerimeter(AstrObject a, AstrObject b, AstrObject c) {
		return a.getDistanceTo(b)+b.getDistanceTo(c)+a.getDistanceTo(c);
	}
	
	public static double getTriangleArea(AstrObject a, AstrObject b, AstrObject c) {
		return Point.getTriangleArea(a.pos, b.pos, c.pos);
	}
	
	public static Line getLine(AstrObject a, AstrObject b) {
		return new Line(a.pos, b.pos);
	}
	
	public boolean isInsideTriangle(AstrObject a, AstrObject b, AstrObject c) {
		double abc = getTriangleArea(a, b, c);
		double thisab = getTriangleArea(this, a, b);
		double thisbc = getTriangleArea(this, b, c);
		double thisac = getTriangleArea(this, a, c);
		return abc == thisab+thisbc+thisac;		
	}
	
	public double getDistanceTo(AstrObject other){
		return this.pos.getDistanceTo(other.pos);
	}
	
}
	
	