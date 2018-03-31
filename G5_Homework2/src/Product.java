import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Product extends Component {
    private ArrayList<Component> components;

    public Product(String name){
        super(String.valueOf(name.charAt(0)));
        components = new ArrayList<Component>();
        setCompositionStructure(name);
        String componentName = String.valueOf(name.charAt(0));
        Component component = new Component(componentName);
        String part1name = String.valueOf(name.charAt(1));
        String part2name = String.valueOf(name.charAt(2));
        Part part1 = new Part(part1name);
        Part part2 = new Part(part2name);
        components.add(component);
        components.add(part1);
        components.add(part2);
    }

    @Override
    public void produce(HashMap<String, Integer> componentsInventory, HashMap<String, Integer> partsInventory) throws InterruptedException {
        System.out.println("Product " + this.getCompositionStructure() + " is being produced.");
        for(Component component: components){
            component.getState().waitToFinish(component, componentsInventory, partsInventory);
        }
        System.out.println("Product " + this.getCompositionStructure() + " is produced.");
    }
}
