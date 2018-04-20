public interface ISubject {
    void attach(IObserver iObserver);
    void detach(IObserver iObserver);
    void notifyAllObservers();
}
