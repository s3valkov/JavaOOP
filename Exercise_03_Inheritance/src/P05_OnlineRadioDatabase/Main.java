package P05_OnlineRadioDatabase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        SongDatabase database = new SongDatabase();

        while (n-- > 0){
            String[] songInfo = scanner.nextLine().split(";");
            try {
                Song song = new Song(songInfo[0],songInfo[1],songInfo[2]);
                database.addSong(song);
            }catch (InvalidSongException ex){
                System.out.println(ex.getMessage());
            }
        }

        System.out.println(database.getTotalLengthOfSongs());
    }
}
