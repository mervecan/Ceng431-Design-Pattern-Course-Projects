import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.print.attribute.standard.PrinterInfo;

public class Product extends Component {
	private ArrayList<Component> components;
	public Product(){
		super();
	}
	
	public Product(HashMap<String, Integer> componentInventory, HashMap<String, Integer> partInventory) {
		/*Random RNG = new Random();
		ArrayList<String> componentKeys = new ArrayList<>(componentInventory.keySet());
		String component = componentKeys.get(RNG.nextInt(componentKeys.size()));
		setCompositionStructure(component + getCompositionStructure());
		int required = RNG.nextInt(3) + 1;
		super.setName(component);
		super.setRequired(required);*/
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return getCompositionStructure();
	}
	
	public void addComponent(Component component){
		components.add(component);
	}
}
