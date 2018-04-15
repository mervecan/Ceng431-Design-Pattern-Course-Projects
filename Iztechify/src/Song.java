public class Song {
    String title;
    String length;

    public Song(String title, String length) {
        this.title = title;
        this.length = length;
    }

    public Song(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
