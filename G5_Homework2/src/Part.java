import java.util.HashMap;
import java.util.Random;

public class Part extends Component {
    boolean needPartProduction;
    public Part(String name){
        Random RNG = new Random();
        setRequired(RNG.nextInt(3)+1);
        setState(new Ordered());
        setName(name);
    }

    @Override
    public void produce(HashMap<String, Integer> componentsInventory, HashMap<String, Integer> partsInventory) throws InterruptedException {
        needPartProduction = super.updateInventory(partsInventory);
        if(!needPartProduction) {
            State ready = new Ready();
            setState(ready);
            ready.waitToFinish(this, componentsInventory, partsInventory);
        }
    }

    public boolean isNeedPartProduction() {
        return needPartProduction;
    }
}
