
public class Observer implements IObserver{
	private int observerState;


	public int getObserverState() {
		return observerState;
	}

	public void setObserverState(int observerState) {
		this.observerState = observerState;
	}



	@Override
	public void update(ISubject subject) {
		observerState = subject.getState();
		
	}
	
	

}
