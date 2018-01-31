package Design.jukebox;

import java.util.ArrayList;
import java.util.List;

public class Artist extends SongCollection {


    public Artist(String name, List<Song> songs) {
        super(songs);
        this.name=name;

    }
    public Artist(String name) {

        super(new ArrayList<Song>());
        this.name=name;
    }

    private String name;

    public String getName() {
        return name;
    }

    protected String getInfo() {
        return "Artist:"+this.name;
    }
}
