package Design.jukebox;

import java.util.LinkedList;
import java.util.Queue;

public class PlaylistMaker implements PlayList {

    private Queue<Song> songs;
    private String name;


    protected PlaylistMaker(SongCollection s){
        this.songs=new LinkedList<Song>();
        for(Song song: s.songs){
            this.songs.offer(song);
        }
    }

    protected PlaylistMaker(){
        this.songs=new LinkedList<Song>();
    }


    public void queueUpSong(Song s) {

        songs.offer(s);

    }

    public void shuffle() {

    }

    public Song getNextSong() {
        return songs.peek();
    }

    public void savePlayList(String name) {
        this.name=name;
    }

    public void playCurrentSong() {
        Song s= songs.poll();
        songs.offer(s);
        s.play();
    }

    public void playNextSong() {
        Song s= songs.poll();
        songs.offer(s);
        playCurrentSong();
    }

}
