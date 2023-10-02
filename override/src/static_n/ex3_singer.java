package static_n;

class Song{
    String title;
    String genre;
    double playTime;

    Song(String title, String genre,double playTime){
        this.title=title;
        this.genre=genre;
        this.playTime=playTime;
    }

    void printSong(){
        System.out.println("제목 : " +title + ", 장르 " +genre+"("+playTime+")");
    }

}
class Singer{
    String name;
    Song[] songList;

    int idx=0;

    Singer(String name,int songCount){
        this.name= name;
        if(songCount>=1){
            songList = new Song[songCount];
        }
    }

    void addSong(Song song){songList[idx++]= song;}
    void printSinger(){
        System.out.println("이름 : " +name);
        System.out.println("대표곡 목록=======");
        for (Song song : songList){
            song.printSong();
        }
    }
}
public class ex3_singer {
    public static void main(String[] args) {
        Singer singer = new Singer("아이브",2);
        singer.addSong(new Song("hype boy","가요",3));
        singer.addSong(new Song("Attention","가요",2.3));
        singer.addSong(new Song("hola","가요",3));
        singer.printSinger();
    }
}
