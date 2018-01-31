package Design.jukebox;

public interface PlayList {

    void queueUpSong(Song s);
    void shuffle();
    Song getNextSong();
    void savePlayList(String name);
    void playCurrentSong();
    void playNextSong();
}
