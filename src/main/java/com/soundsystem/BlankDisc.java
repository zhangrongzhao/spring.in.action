package com.soundsystem;

import java.util.List;

public class BlankDisc implements CompactDisc {
    private String title=null;
    private String artist=null;
    private List<String> tracks=null;

    public BlankDisc(){}

    public BlankDisc(String title,String artist,List<String> tracks){
        this.title=title;
        this.artist=artist;
        this.tracks=tracks;
    }

    public void setTitle(String title){this.title=title;}
    public void setArtist(String artist){this.artist=artist;}
    public void setTracks(List<String> tracks){this.tracks=tracks;}


    public void play() {

    }

    public void play(int trackNumber) {

    }
}
