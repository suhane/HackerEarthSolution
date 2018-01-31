package Design.jukebox;

public class TestPlayer {

    public static void  main(String args[]){


        SongCollection dangal= new Album("Dangal","2016");
        SongCollection sonu= new Artist("Sonu Nigam");
        SongCollection alka= new Artist("Alka Yagnik");
        SongCollection raftar= new Artist("Raftaar");

        Song s1= new Song("Dangal dangal",dangal,raftar);//songcollection.add(new Song("dhakd","dangal","raftaar"))
        Song s2= new Song("naina",dangal,alka);
        Song s3= new Song("dhakad",dangal,sonu);

        JukeBox jukeBox=JukeBox.getInstance();

        PlayList defaultPlayList=jukeBox.createPlayList();
        defaultPlayList.queueUpSong(s1);
        defaultPlayList.queueUpSong(s2);
        defaultPlayList.playCurrentSong();
        defaultPlayList.playCurrentSong();
        defaultPlayList.playCurrentSong();


        PlayList artistPlayList=jukeBox.createPlayListFromCollection(sonu);
        artistPlayList.playCurrentSong();
        artistPlayList.playCurrentSong();

    }
}
