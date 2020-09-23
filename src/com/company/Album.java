package com.company;

import java.util.ArrayList;

public class Album {

    ArrayList<Song> songsArrayList;
    private String albumName;

    public Album(String albumName) {
        this.albumName = albumName;
        songsArrayList = new ArrayList<>();
    }

    public String getAlbumName() {
        return albumName;
    }
}
