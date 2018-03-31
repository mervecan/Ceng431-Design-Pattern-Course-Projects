import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Component implements ICompenent{
    private String name;
    private String compositionStructure;
    private int required;
    private State state;

    public Component(){}

    public Component(String name){
        this.name = name;
        setState(new Waiting());
    }

    public void produce(HashMap<String, Integer> componentsInventory, HashMap<String, Integer> partsInventory) throws InterruptedException {
        Random RNG = new Random();
        required = RNG.nextInt(3)+1;
        System.out.println(String.valueOf(required) + " " + getName() + " is required.");
        boolean needPartProduction = updateInventory(componentsInventory);

        if(needPartProduction){
            String parts = ManufacturerProductionModule.generateRandomPartName(2, name);
            String part1name = String.valueOf(parts.charAt(0));
            String part2name = String.valueOf(parts.charAt(1));

            Part part1 = new Part(part1name);
            Part part2 = new Part(part2name);
            part1.getState().waitToFinish(part1, componentsInventory, partsInventory);
            part2.getState().waitToFinish(part2, componentsInventory, partsInventory);
            compositionStructure = parts;
        }

    }

    public boolean updateInventory(HashMap<String, Integer> inventory){
        int componentCount = inventory.get(name);
        if(componentCount >= getRequired()) {
            System.out.println("There is " + String.valueOf(componentCount) + " in the inventory.");
            inventory.remove(name);
            componentCount = componentCount - getRequired();
            inventory.put(name, componentCount);
            System.out.println("There will be " + String.valueOf(componentCount) + " left in the inventory after production.");
            this.setState(new Ready());
            return false;
        }
        System.out.println("There is not enough " + getName() + " in the inventory.");
        return true;
    }

    public String getCompositionStructure() {
        return compositionStructure;
    }

    public void setCompositionStructure(String compositionStructure) {
        this.compositionStructure = compositionStructure;
    }

    public int getRequired() {
        return required;
    }

    public void setRequired(int required) {
        this.required = required;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return getName();
    }
}
