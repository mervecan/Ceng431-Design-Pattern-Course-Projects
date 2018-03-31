import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ManufacturerProductionModule {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Product> products = new ArrayList<>();
        HashMap<String, Integer> componentsInventory = new HashMap<>();
        HashMap<String, Integer> partsInventory = new HashMap<>();
        InitializeInventory(componentsInventory, partsInventory, 6);

        newProduct(products, componentsInventory, partsInventory);
        products.get(0).produce(componentsInventory, partsInventory);
    }

    public static void newProduct(ArrayList<Product> products, HashMap<String, Integer> componentsInventory, HashMap<String, Integer> partsInventory){
        String productName = generateRandomProductName(componentsInventory, partsInventory);
        System.out.println(productName);
        Product product = new Product(productName);
        products.add(product);
    }

    public static void printInventoryInformation(HashMap<String, Integer> inventory){
        for(String key: inventory.keySet()){
            String value = inventory.get(key).toString();
            System.out.println(key + ":" + value);
        }

    }

    public static String generateRandomProductName(HashMap<String, Integer> componentsInventory, HashMap<String, Integer> partsInventory){
        Random RNG = new Random();
        String componentName = elementAtIndex(RNG.nextInt(componentsInventory.size()), componentsInventory);
        String part1 = elementAtIndex(RNG.nextInt(partsInventory.size()), partsInventory);
        String part2 = "";
        do {
             part2 = elementAtIndex(RNG.nextInt(partsInventory.size()), partsInventory);
        }while (part1.equals(part2));
        return componentName+part1+part2;
    }

    public static String generateRandomComponentName(int stringLength) {
        String alphabet= "abcdefghi";
        alphabet = alphabet.toUpperCase();
        String s = "";
        Random random = new Random();

        for (int i = 0; i < stringLength; i++) {
            char c = alphabet.charAt(random.nextInt(alphabet.length()));
            if(s.indexOf(c) < 0){
                s+=c;
            }
            else{
                i--;
            }
        }

        return s;
    }

    public static String generateRandomPartName(int stringLength, String seed) {
        String alphabet= "jklmnopqrstuvwxyz";
        alphabet = alphabet.toUpperCase();
        String s = "";
        Random random = new Random(stringToSeed(seed));

        for (int i = 0; i < stringLength; i++) {
            char c = alphabet.charAt(random.nextInt(alphabet.length()));
            if(s.indexOf(c) < 0){
                s+=c;
            }
            else{
                i--;
            }
        }

        return s;
    }

    public static long stringToSeed(String s) {
        if (s == null) {
            return 0;
        }
        long hash = 0;
        for (char c : s.toCharArray()) {
            hash = 31L*hash + c;
        }
        return hash;
    }

    public static void InitializeInventory(HashMap<String, Integer> componentsInventory, HashMap<String, Integer> partsInventory, int n){
        Random RNG = new Random();
        while(componentsInventory.size()<n) {
            String componentName = generateRandomComponentName(1);
            //Using the component name as seed, we always generate the same random parts for each component
            String parts = generateRandomPartName(2, componentName);
            String part1name = String.valueOf(parts.charAt(0));
            String part2name = String.valueOf(parts.charAt(1));

            //Assumed max storage for each component and part as 3
            componentsInventory.putIfAbsent(componentName, RNG.nextInt(6));
            partsInventory.putIfAbsent(part1name, RNG.nextInt(6));
            partsInventory.putIfAbsent(part2name, RNG.nextInt(6));
        }

    }

    public static String elementAtIndex(int index, HashMap<String, Integer> inventory){
        ArrayList<String> keys = new ArrayList<>(inventory.keySet());
        String key = keys.get(index);
        return key;
    }
}
