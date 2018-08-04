package galaxy;

import java.math.*;

/*A class for Astronomic objects in the galaxy that also move*/
public class MovingObject extends AstrObject{
	/* angle refers to the one formed by the positive half of the y-axis 
	  and the line that passes through the object and the sun. 
	  Similarly to distanceToSun, is not needed for doing the calculations 
	  (it's defined by X and Y).
	  Keeping it stored, though, allows dayMove() to be faster.*/
	double angle, degreesPerDay;
	boolean clockwise;
	Point startingPos;
	public MovingObject(double x, double y, String name, int dPD, boolean cw) {
		super(x, y, name);
		startingPos=new Point(x, y);
		degreesPerDay=dPD%360;
		clockwise=cw;
	}
	
	public static double round(double value, int places) {
	    BigDecimal number = new BigDecimal(value);
	    number = number.setScale(places, RoundingMode.HALF_UP);
	    return number.doubleValue();
	}
	
	public void dayMove() {
		angle+=(clockwise? 1:-1)*degreesPerDay%360;
		pos.x=round(Math.sin(Math.toRadians(angle)) * distanceToSun, 2);
		pos.y=round(Math.cos(Math.toRadians(angle)) * distanceToSun, 2);
	}

	public boolean onStartPos() {
		return pos.equals(startingPos);
	}			
}	

