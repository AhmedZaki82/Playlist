package com.company;

public class Song {

    private String songName;
    private String songDuration;

    public Song(String songName, String songDuration) {
        this.songName = songName;
        this.songDuration = songDuration;
    }

    public String getSongName() {
        return songName;
    }

    public String getSongDuration() {
        return songDuration;
    }
}
