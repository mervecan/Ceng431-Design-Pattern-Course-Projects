public interface ISubject {
	public void attach();
	public void detach();
	public void notifyObservers();
	public void stateChanged();
	public int getState();
	public void setState(int state);
}
