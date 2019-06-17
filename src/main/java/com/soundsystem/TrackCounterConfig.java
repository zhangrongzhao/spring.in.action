//package com.soundsystem;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//@EnableAspectJAutoProxy
//public class TrackCounterConfig {
//
//    @Bean
//    public CompactDisc sgtPepper(){
//        BlankDisc cd=new BlankDisc();
//        cd.setTitle("A");
//        cd.setArtist("A@1");
//        List<String> tracks=new ArrayList<String>();
//        tracks.add("A#1");
//        tracks.add("A#2");
//        tracks.add("A#3");
//        tracks.add("A#4");
//        tracks.add("A#5");
//        tracks.add("A#6");
//        cd.setTracks(tracks);
//        return cd;
//    }
//
//    @Bean
//    public TrackCounter trackCounter(){
//        return new TrackCounter();
//    }
//}
