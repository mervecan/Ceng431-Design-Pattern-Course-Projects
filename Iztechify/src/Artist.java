import java.util.ArrayList;
import java.util.List;

public class Artist implements IArtist{
   private String name;
   private List<Album> albums;
   private int state;
   private ArrayList<IObserver> observers = new ArrayList<>();

   	public Artist() {
   		
   	}
	public Artist(String name, List<Album> albums) {
	    this.name = name;
	    this.albums = albums;
	}
	
	public String getName() {
	    return name;
	}
	
	public void setName(String name) {
	    this.name = name;
	}
	
	public List<Album> getAlbums() {
	    return albums;
	}
	
	public void setAlbums(List<Album> albums) {
	    this.albums = albums;
	}
	
	public ArrayList<IObserver> getObservers() {
		return observers;
	}
	
	public void setObservers(ArrayList<IObserver> observers) {
		this.observers = observers;
	}
	
	public void addAlbum(Album album){
	    albums.add(album);
	}
	
	public void deleteAlbum(Album album){
	    albums.remove(album);
	}
	
	@Override
	public void attach() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void detach() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void stateChanged() {
		// TODO Auto-generated method stub
			
	}
	
	public int getState() {
			return state;
	}
	
	public void setState(int state) {
			this.state = state;
	}
		
		
		
	}
