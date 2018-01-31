package Design.jukebox;

public class Song {

    private String title;
    private SongCollection artist;
    private SongCollection album;

    public Song(String title, SongCollection artist, SongCollection album){

        this.title=title;
        this.artist=artist;
        this.album=album;

        artist.register(this);
        album.register(this);
    }

    public String getInfo(){
        return "Title:"+this.title+"\n"+this.artist.getInfo()+"\n"+this.album.getInfo();
    }

    public void play(){
        System.out.println("The song "+this.title+" is playing");
    }

}
