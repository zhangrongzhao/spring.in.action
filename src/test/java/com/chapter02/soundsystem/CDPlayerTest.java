//package com.zrz.chapter02.soundsystem;
//
//import com.zrz.chapter02.config.SoundSystemConfig;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import static junit.framework.TestCase.assertEquals;
//import static junit.framework.TestCase.assertNotNull;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes= SoundSystemConfig.class)
//public class CDPlayerTest {
//
//    @Rule
//    public final StandardOutputStreamLog log=new StandardOutputStreamLog();
//
//    @Autowired
//    private MediaPlayer player;
//
//    @Autowired
//    private CompactDisc compactDisc;
//
//    @Test
//    public void cdShouldNotBeNull(){
//         assertNotNull(compactDisc);
//    }
//
//    @Test
//    public void play(){
//        player.play();
//        assertEquals("",log.getLog());
//    }
//}
