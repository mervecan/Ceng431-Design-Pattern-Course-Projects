import java.util.HashMap;
import java.util.Random;

public class InQualityControl implements State {
    public InQualityControl(){}

    @Override
    public void daysToWait(int maxDay) throws InterruptedException {
        Random RNG = new Random();
        int daysToWait = RNG.nextInt(maxDay-1) + 1;
        synchronized (this) {
            this.wait(daysToWait * 250);
        }
    }

    @Override
    public void waitToFinish(Component part, HashMap<String, Integer> componentsInventory, HashMap<String, Integer> partsInventory) throws InterruptedException {
        System.out.println("Part " + part.toString() + " is in quality control.");
        daysToWait(3);
        System.out.println("Part " + part.toString() + " is out of quality control.");
        part.setState(new Ready());
        part.getState().waitToFinish(part, componentsInventory, partsInventory);
    }
}
