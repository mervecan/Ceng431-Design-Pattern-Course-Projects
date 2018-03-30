import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ManufacturerProductionModule {
	
	public static void main(String[] args) {
		ArrayList<Product> products;
		HashMap<String, Integer> componentInventory = new HashMap<>();
		HashMap<String, Integer> partInventory = new HashMap<>();
		
		componentInventory.put("A", 2);
		componentInventory.put("B", 1);
		componentInventory.put("C", 1);
		componentInventory.put("D", 1);
		componentInventory.put("F", 1);
		
		partInventory.put("X", 2);
		partInventory.put("Y", 2);
		partInventory.put("Z", 2);
		partInventory.put("T", 2);
		partInventory.put("H", 2);
		partInventory.put("Q", 2);
		
		Product product = new Product(componentInventory, partInventory);
		System.out.println(product.getCompositionStructure());
	}
}
