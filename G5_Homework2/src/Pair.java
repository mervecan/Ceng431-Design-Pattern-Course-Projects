
public class Pair {
	private Character id;
	private Integer value;
	
	public Pair() {
	}
	
	public Pair(Character id, Integer value){
		this.id = id;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Name: " + id + " Required Amount: " + value.toString();
	}

}
