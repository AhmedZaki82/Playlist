package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Playlist {

    ArrayList<Album> albumsArrayList;
    LinkedList<Song> playlistLinkedList;
    Scanner scanner = new Scanner(System.in);

    public Playlist() {
        this.albumsArrayList = new ArrayList<>();
        this.playlistLinkedList = new LinkedList<>();
    }

    public void playlist() {
        boolean cont = true;
        printPlaylistMenu();
        ListIterator<Song> listIterator = playlistLinkedList.listIterator();
        boolean goingForward = true;

        while (cont) {
            System.out.println("Choose an Action:");
            int action = scanner.nextInt();

            switch (action) {

                case 0:
                    printPlaylistMenu();
                    break;

                case 1:
                    if (playlistLinkedList.isEmpty()) {
                        System.out.println("There is no Songs yet!");
                    }

                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }

                    if (listIterator.hasNext()) {
                        System.out.println(listIterator.next().getSongName());
                    } else {

                        System.out.println("We are at the end of the Playlist!");
                        goingForward = false;
                    }
                    break;

                case 2:

                    if (goingForward) {

                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                            goingForward = false;
                        }

                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println(listIterator.previous().getSongName());
                        goingForward = false;
                    } else {
                        System.out.println("We are at the begining of the Playlist!");
                        goingForward = true;
                    }
                    break;

                case 3:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println(listIterator.previous().getSongName());
                            goingForward = false;
                        }

                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println(listIterator.next().getSongName());
                            goingForward = true;
                        }

                    }
                    break;

                case 4:
                    displayPlaylistSongs();
                    break;

                case 5:
                    cont = false;
                    break;

            }
        }

    }

    public void album() {

        boolean cont = true;
        printAlbumMenu();
        ListIterator<Song> listIterator = playlistLinkedList.listIterator();

        while (cont) {
            System.out.println("Choose an Action: ");
            int action = scanner.nextInt();

            switch (action) {

                case 0:
                    printAlbumMenu();
                    break;

                case 1:
                    newAlbum();
                    break;

                case 2:
                    addSongAlbum();
                    break;

                case 3:
                    displayAlbums();
                    break;

                case 4:
                    displayAlbumSongs();
                    break;

                case 5:
                    addSongList();
                    break;

                case 6:
                    removeSongList();
                    break;

                case 7:
                    displayPlaylistSongs();
                    break;

                case 8:
                    playlist();
                    break;

                case 9:
                    cont = false;
                    break;
            }


        }
    }

    private void newAlbum(String albumName) {
        albumsArrayList.add(new Album(albumName));
    }

    private void addSongAlbum(String albumName, String songName, String songDuration) {
        for (int i = 0; i < albumsArrayList.size(); i++) {

            if (albumsArrayList.get(i).getAlbumName().equals(albumName)) {
                albumsArrayList.get(i).songsArrayList.add(new Song(songName, songDuration));
            }
        }
    }

    private void displayAlbums() {
        for (int i = 0; i < albumsArrayList.size(); i++) {
            System.out.println((i + 1) + "." + albumsArrayList.get(i).getAlbumName());
        }
    }

    private void displayAlbumSongs(String albumName) {
        for (int i = 0; i < albumsArrayList.size(); i++) {

            if (albumsArrayList.get(i).getAlbumName().equals(albumName)) {

                for (int j = 0; j < albumsArrayList.get(i).songsArrayList.size(); j++) {
                    System.out.println((j + 1) + "." + albumsArrayList.get(i).
                            songsArrayList.get(j).getSongName());
                }
            }

        }
    }

    public void printAlbumMenu() {
        System.out.println("\n0.Print Album Menu.\t" + "1.Add New Album.\t" + "2.Add New Song to the Album!\t" +
                "3.Display Albums!\t" + "4.Display Album Songs\t\n" + "5.Add a Song to the Playlist!\t" +
                "6.Remove Song List!\t" + "7.Display List Songs!\t" + "8.Enter the Playlist!\t" + "9.Exit!");
    }

    private void newAlbum() {
        System.out.println("Enter the Album Name:");
        String name = scanner.next();
        name += scanner.nextLine();

        newAlbum(name);
    }

    private void addSongAlbum() {
        System.out.println("Enter the Album Name:");
        String albumName = scanner.next();
        albumName += scanner.nextLine();

        System.out.println("Enter the Song name:");
        String songName = scanner.next();
        songName += scanner.nextLine();

        System.out.println("Enter the Song Duration");
        String songDuration = scanner.next();
        songDuration += scanner.nextLine();

        addSongAlbum(albumName, songName, songDuration);
    }

    private void displayAlbumSongs() {
        System.out.println("Enter the Album Name:");
        String name = scanner.next();
        name += scanner.nextLine();

        displayAlbumSongs(name);
    }

    private void addSongList(String songName) {
        for (int i = 0; i < albumsArrayList.size(); i++) {

            for (int j = 0; j < albumsArrayList.get(i).songsArrayList.size(); j++) {
                if (albumsArrayList.get(i).songsArrayList.get(j).getSongName().equals(songName)) {
                    playlistLinkedList.add(albumsArrayList.get(i).songsArrayList.get(j));
                }
            }
        }
    }

    private void displayPlaylistSongs() {
        for (int i = 0; i < playlistLinkedList.size(); i++) {
            System.out.println((i + 1) + "." + playlistLinkedList.get(i).getSongName());
        }
    }


    public void printPlaylistMenu() {
        System.out.println("\n0.Print the Playlist!\t" + "1.Next Song!\t" + "2.Previous Song!\t" +
                "3.Repeat the current Song\t"+  "4.Display Playlist Songs!\t" + "5.Exit!");
    }

    private void removeSongList() {

        ListIterator<Song> listIterator = playlistLinkedList.listIterator();
        System.out.println("Enter the name of the song to remove from the list:");
        String songName = scanner.next();
        songName += scanner.nextLine();

        while (listIterator.hasNext()) {

            if (listIterator.next().getSongName().equals(songName)) {
                listIterator.remove();
                break;
            }
        }

    }

    public void addSongList() {
        System.out.println("Enter the Song Name:");
        String name = scanner.next();
        name += scanner.nextLine();

        addSongList(name);
    }
}
