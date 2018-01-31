package Design.jukebox;
import java.util.ArrayList;

public class Album extends SongCollection {

    private String name;
    private String year;

    public Album(String name, String year) {
        super(new ArrayList<Song>());
        this.name=name;
        this.year=year;
    }

    protected String getInfo() {
        return "Album:"+this.name+"\tYear of release:"+this.year;
    }
}
