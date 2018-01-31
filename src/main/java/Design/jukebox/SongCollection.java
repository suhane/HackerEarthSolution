package Design.jukebox;
import java.util.List;


public abstract class SongCollection {

    protected List<Song> songs;

    protected SongCollection(List<Song> songs){
        this.songs=songs;
    }

    protected void register(Song s){
        songs.add(s);
    }

    protected abstract String getInfo();



}
