package Design.jukebox;

public class JukeBox {

    private static JukeBox instance;

    private PlayList currentPlaylist;


    public static JukeBox getInstance() {
        if(instance==null)
            instance= new JukeBox();
        return instance;
    }

    public PlayList createPlayList(){
        return new PlaylistMaker();
    }

    public PlayList createPlayListFromCollection(SongCollection s){
        return new PlaylistMaker(s);
    }


    public void setCurrentPlaylist(PlayList currentPlaylist) {
        this.currentPlaylist = currentPlaylist;
    }


}
