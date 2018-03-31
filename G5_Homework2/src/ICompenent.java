import java.util.HashMap;

public interface ICompenent {
    public void produce(HashMap<String, Integer> componentsInventory, HashMap<String, Integer> partsInventory) throws InterruptedException;
}
