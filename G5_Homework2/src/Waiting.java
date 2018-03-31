import java.util.HashMap;

public class Waiting implements State {
    @Override
    public void waitToFinish(Component component, HashMap<String, Integer> componentsInventory, HashMap<String, Integer> partsInventory) throws InterruptedException {
        System.out.println(component.getClass().getName() + " " + component.toString() + " is waiting for parts to finish");
        component.produce(componentsInventory, partsInventory);
        component.setState(new Ready());
        component.getState().waitToFinish(component, componentsInventory, partsInventory);
    }

    @Override
    public void daysToWait(int maxDay) throws InterruptedException {
    }
}
