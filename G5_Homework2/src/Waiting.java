
public class Waiting implements StateOfComponent{

	public Waiting(Component component) {
		String compositeStructure = component.getCompositionStructure();
		Character part1 = compositeStructure.charAt(0);
		Character part2 = compositeStructure.charAt(1);
		
		
	}

	@Override
	public void waitForDays(Component component) {
		
	}

}
