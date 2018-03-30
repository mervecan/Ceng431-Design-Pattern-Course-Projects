import java.util.Random;

public class Ordered implements StateOfPart {

	public Ordered(Part part) {
		waitForDays(part);
	}

	@Override
	public void waitForDays(Part part) {
		Random RNG = new Random();
		int daysToWait = RNG.nextInt(9) + 1;
		try {
			wait(daysToWait*1000);
		} catch (InterruptedException e) {
		}
		
		part.setState(new InQualityControl(part));
	}

}
