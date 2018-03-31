import java.util.HashMap;

public interface State{
    void waitToFinish(Component component, HashMap<String, Integer> componentsInventory, HashMap<String, Integer> partsInventory) throws InterruptedException;
    void daysToWait(int maxDay) throws InterruptedException;
}

