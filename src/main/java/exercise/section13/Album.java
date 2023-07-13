package exercise.section13;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return songs.add(new Song(title, duration));
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {

        if (trackNumber <= 0) {
            return false;
        }
        Song song = songs.findSong(trackNumber - 1);
        if (song == null) {
            return false;
        }
        playlist.addLast(song);

        return true;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {

        Song song = songs.findSong(title);
        if (song == null) {
            return false;
        }
        playlist.addLast(song);

        return true;
    }

    static class SongList {

        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<>();
        }

        private boolean add(Song song) {

            Song findSong = findSong(song.getTitle());
            if (findSong == null) {
                songs.add(song);
                return true;
            }

            return false;
        }

        private Song findSong(String title) {

            for (Song song : songs) {
                if (song.getTitle().equals(title)) {
                    return song;
                }
            }

            return null;
        }

        private Song findSong(int num) {
            return (num < 0) ? null : (num >= songs.size()) ? null : songs.get(num);
        }
    }
}
