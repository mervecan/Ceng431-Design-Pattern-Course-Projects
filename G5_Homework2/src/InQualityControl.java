import java.util.Random;

public class InQualityControl implements StateOfPart {

	public InQualityControl(Part part) {
		waitForDays(part);
	}
	
	@Override
	public void waitForDays(Part part) {
		Random RNG = new Random();
		int daysToWait = RNG.nextInt(2) + 1;
		try {
			wait(daysToWait*1000);
		} catch (InterruptedException e) {
		}
		
		part.setState(new Ready());
	}


}
