package P05_OnlineRadioDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SongDatabase {
    private List<Song> songs;

    public SongDatabase() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        this.songs.add(song);
        System.out.println("Song added.");
    }

    public String getTotalLengthOfSongs() {
        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        for (Song song : songs) {
            int[] lengthInfo = Arrays.stream(song.getLength().split(":"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            minutes += lengthInfo[0];
            seconds += lengthInfo[1];
        }

        minutes += seconds / 60;
        hours += minutes / 60;
        seconds %= 60;
        minutes %= 60;

        String songLength = hours + "h " + minutes + "m " + seconds + "s";
        return "Songs added: " + this.songs.size() + System.lineSeparator() + "Playlist length: " + songLength;
    }


}
