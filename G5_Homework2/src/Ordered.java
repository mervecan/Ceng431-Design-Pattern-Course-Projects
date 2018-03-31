import java.util.HashMap;
import java.util.Random;

public class Ordered implements State {
    @Override
    public void daysToWait(int maxDay) throws InterruptedException {
        Random RNG = new Random();
        int daysToWait = RNG.nextInt(maxDay-1) + 1;
        synchronized (this) {
            this.wait(daysToWait * 250);
        }
    }

    @Override
    public void waitToFinish(Component component, HashMap<String, Integer> componentsInventory, HashMap<String, Integer> partsInventory) throws InterruptedException {
        System.out.println("Part " + component.toString() + " is waiting to process order.");
        component.produce(componentsInventory, partsInventory);
        daysToWait(10);
        Part part = (Part) component;
        if(!part.getState().getClass().getName().equals("Ready")) {
            System.out.println("Part " + component.toString() + " is ordered.");
            part.setState(new InQualityControl());
            part.getState().waitToFinish(component, componentsInventory, partsInventory);
        }
    }
}
