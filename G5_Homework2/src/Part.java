public class Part extends Component{

	public Part(String name) {
		super.setState(new Ordered(this));
		setName(name);
	}
	
	@Override
	public String getName() {
		return getCompositionStructure();
	}
	
	@Override
	public State getState() {
		return super.getState();
	}
	
	@Override
	public boolean isReady(){
		return getState().getClass().equals(Ready.class) && super.isReady();
	}
	
}
