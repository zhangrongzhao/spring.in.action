package com.soundsystem;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SgtPeppers implements CompactDisc {
    private String title="Sgt";
    private String artist="The Beatless";


    public void play(){
         System.out.println("Playing "+title+" by "+artist);
    }

    public void play(int trackNumber) {

    }
}
