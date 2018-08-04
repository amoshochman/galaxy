package galaxy;

import java.util.*;

public class Galaxy {
	
	private Vector<MovingObject> planets = new Vector<MovingObject>();
	private AstrObject sun;
	private List<Integer> supportedNumOfPlanets, maxRainDays;
	private double maxPerimeterReached;
	private int droughtPeriods,	optimalPTPeriods, rainPeriods, dayNumber;
	
	public Galaxy() {
		planets = new Vector<MovingObject>();
		sun = new AstrObject(0, 0, "Sun");
		supportedNumOfPlanets=new ArrayList<Integer>();
		supportedNumOfPlanets.add(3);
		resetCounters();
		System.out.println("New galaxy created. Plase notice that the value of the counters"
				+ " are undefined if the number of planets is not among "+supportedNumOfPlanets);
	}
	
	public void resetCounters() {
		dayNumber=0;
		maxPerimeterReached=0;
		droughtPeriods=0;
		optimalPTPeriods=0;
		rainPeriods=0;
		maxRainDays=new ArrayList<Integer>();
	}

	public void add(MovingObject planet) throws Exception {
		checkName(planet.name);
		planets.add(planet);
		resetCounters();
	}
	
	public void remove(String name) throws Exception {
		for (int i=0;i<planets.size();i++) {
			if (planets.get(i).name.equals(name)) {
				planets.remove(i);
				resetCounters();
				return;
			}
		}
		throw new Exception("Can't remove "+name+", no such planet in the galaxy.");	
	}
	
	private void checkName(String name) throws Exception {
		for (int i=0;i<planets.size();i++) {
			if (planets.get(i).name.equals(name)) {
				throw new Exception("There's already a planet called "+name+
						" in the galaxy.");	
			}
		}
	}

	public boolean onRainPeriod() {
		return sun.isInsideTriangle(planets.get(0), planets.get(1), planets.get(2));
	}
	
	private boolean arePlanetsAligned() {
		if (planets.size()<=2) {
			return true;
		}
		for (int i=2;i<planets.size();i++) {
			if (!AstrObject.areInOneLine
					(planets.get(i-2),planets.get(i-1),planets.get(i))){
				return false;
			}
		}
		return true;
	}
	
	public boolean onOptimalPT() {
		return arePlanetsAligned() && 
				!AstrObject.areInOneLine(planets.get(0),planets.get(1),sun);
	}

	public boolean onDroughtPeriod() {
		return arePlanetsAligned() && 
				AstrObject.areInOneLine(planets.get(0),planets.get(1),sun);
	}
	
	public double getCurrentPerimeter() {
		return AstrObject.getTrianglePerimeter(planets.get(0), planets.get(1), planets.get(2));
	}
	
	public void dayMove() {
		dayNumber++;
		for (int i=0;i<planets.size();i++) {
			planets.get(i).dayMove();
		}
		if (planets.size()!=3) {
			return;
		}
		if (onDroughtPeriod()) {
			droughtPeriods++;
		} else if (onOptimalPT()) {
			optimalPTPeriods++;
		} else if (onRainPeriod()) {
			updateRainCounters();
		}
	}

	private void updateRainCounters() {
		rainPeriods++;
		double curPerimeter=getCurrentPerimeter();
		if (curPerimeter>maxPerimeterReached) {
			maxPerimeterReached=curPerimeter;
			maxRainDays.clear();
			maxRainDays.add(dayNumber);
		}
		else if (curPerimeter==maxPerimeterReached){
			maxRainDays.add(dayNumber);
		}
	}
	
	public boolean onStartPos() {
		for (int i=0;i<planets.size();i++) {
			if (!planets.get(i).onStartPos()) {
				return false;
			}
		}
		return true;
	}

	public int getDroughtPeriods() {
		return droughtPeriods;
	}

	public int getRainPeriods() {
		return rainPeriods;
	}

	public List<Integer> getMaxRainDays() {
		return maxRainDays;
	}

	public int getOptimalPTPeriods() {
		return optimalPTPeriods;
	}
}
