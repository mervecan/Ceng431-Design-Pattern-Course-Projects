import java.util.HashMap;

public class Ready implements State {

    @Override
    public void waitToFinish(Component component, HashMap<String, Integer> componentsInventory, HashMap<String, Integer> partsInventory) throws InterruptedException {
        System.out.println(component.getClass().getName() + " " + component.toString() + " is ready.");
    }

    @Override
    public void daysToWait(int maxDay) {

    }
}
