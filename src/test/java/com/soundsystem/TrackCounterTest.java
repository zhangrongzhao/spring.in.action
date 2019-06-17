package com.soundsystem;

import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"/soundsystem/soundsystem.config.xml"})
public class TrackCounterTest {

    public final StandardOutputStreamLog log=new StandardOutputStreamLog();

    @Autowired
    private CompactDisc cd;

    @Autowired
    private TrackCounter trackCounter;

    @Test
    public void testTrackCounter(){
        cd.play(1);
        cd.play(2);
        cd.play(2);
        cd.play(3);
        cd.play(3);
        cd.play(3);
        cd.play(4);
        cd.play(4);
        cd.play(5);
        cd.play(7);

        assertEquals(1,trackCounter.getPlayCount(1));
        assertEquals(2,trackCounter.getPlayCount(2));
        assertEquals(3,trackCounter.getPlayCount(3));
        assertEquals(2,trackCounter.getPlayCount(4));
        assertEquals(1,trackCounter.getPlayCount(5));
        assertEquals(1,trackCounter.getPlayCount(7));
    }
}
