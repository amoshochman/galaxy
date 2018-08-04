package galaxy;
import java.util.*;

public class Test {
	static int totalDays = 365 * 10;

	public static void main(String[] args) throws Exception {
		Galaxy galaxy = new Galaxy();
		galaxy.add(new MovingObject(0, 500, "Ferengi", 1, true));
		galaxy.add(new MovingObject(0, 2000, "Betasoide", 3, true));
		galaxy.add(new MovingObject(0, 1000, "Vulcano", 5, false));
		int cycleDuration=totalDays;
		//This allows us to get the results also for much bigger values of totalDays.
		//Afterwards we check if cycleDuration remains equal to totalDays.
		//That would mean, there's no such cycle.
		for (int i = 0; i <totalDays; i++) {
			galaxy.dayMove();
			if (galaxy.onStartPos()) {
				cycleDuration=i+1;
				break;
			}
		}
		int cycleNumbers=totalDays/cycleDuration;
		int droughtP=galaxy.getDroughtPeriods()*cycleNumbers;
		int rainP=galaxy.getRainPeriods()*cycleNumbers;
		int optimalPT=galaxy.getOptimalPTPeriods()*cycleNumbers;
		List<Integer> maxRain=galaxy.getMaxRainDays();
		
		if (cycleDuration!=totalDays) {
			galaxy.resetCounters();
			for (int i = 0; i < totalDays%(cycleNumbers*cycleDuration); i++) {
				galaxy.dayMove();
			}
			droughtP+=galaxy.getDroughtPeriods();
			rainP+=galaxy.getRainPeriods();
			optimalPT+=galaxy.getOptimalPTPeriods();
		}
		
		System.out.println("There will be:");
		System.out.println(droughtP + " drought periods.");
		System.out.println(rainP + " rain periods, "
				+ "with the pick on day numbers: " + maxRain);
		if (cycleDuration!=totalDays) {
			System.out.println("(Pick rain days are also verified "+cycleDuration+" days, "+
								cycleDuration+"*2 days, etc., after each one of the mentioned above, "
								+ "IF BEFORE THE END OF THE REQUESTED PERIOD.)");
		}
		System.out.println(optimalPT + " optimal pression and temperature conditions periods.");
	}
}
