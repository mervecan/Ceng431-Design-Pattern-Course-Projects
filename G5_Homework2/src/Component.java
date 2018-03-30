import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public abstract class Component {
	private String name;
	private String compositionStructure;
	private HashSet<Pair> requiredAmount;
	private State state;
	private int required;

	public Component(){}
	
	public Component(String name, HashMap<String, Integer> partInventory) {
		/*state = new Waiting(this);
		Random RNG = new Random();
		compositionStructure = "";
		requiredAmount = new HashSet<>();
		ArrayList<String> partKeys = new ArrayList<>(partInventory.keySet());
		String part1 = partKeys.get(RNG.nextInt(partKeys.size()));
		String part2;
		do {
			part2 = partKeys.get(RNG.nextInt(partKeys.size()));
		} while (part2.equals(part1));
		
		int required1 = RNG.nextInt(3) + 1;
		int required2 = RNG.nextInt(3) + 1;
		addPair(part1, required1);
		addPair(part2, required2);
		compositionStructure = part1+part2;*/
	}
	
	private String generateRandomString(int stringLength, String seed) {
		String alphabet= "abcdefghijklmnopqrstuvwxyz";
		alphabet = alphabet.toUpperCase();
        String s = "";
        Random random = new Random(stringToSeed(seed));

        for (int i = 0; i < stringLength; i++) {
            char c = alphabet.charAt(random.nextInt(26));
            if(s.indexOf(c) < 0){
            	s+=c;
            }
            else{
            	i--;
            }
        }
        
        return s;
	}

	static long stringToSeed(String s) {
	    if (s == null) {
	        return 0;
	    }
	    long hash = 0;
	    for (char c : s.toCharArray()) {
	        hash = 31L*hash + c;
	    }
	    return hash;
	}
	
	public String getCompositionStructure() {
		return compositionStructure;
	}

	public void setCompositionStructure(String compositionStructure) {
		this.compositionStructure = compositionStructure;
	}

	public HashSet<Pair> getRequiredAmount() {
		return requiredAmount;
	}
	
	public void addPair(String id, int value){
		requiredAmount.add(new Pair(id.charAt(0), value));
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getRequired() {
		return required;
	}
	
	public boolean isReady(){
		return state.getClass().equals(Ready.class);
	}

	public void setRequired(int required) {
		this.required = required;
	}
	
}
