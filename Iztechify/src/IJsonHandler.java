import java.io.IOException;

public interface IJsonHandler extends IObserver{
    public void readJson();
    public void updateJson();
    public boolean removeObject(ISubject subject);
    public boolean addObject(ISubject subject);
}
