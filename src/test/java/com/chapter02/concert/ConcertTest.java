package com.chapter02.concert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"/chapter02/concert-config.xml"})
public class ConcertTest {

    @Autowired
    private Performance performance;

    @Test
    public void testEncoreable(){
        Encoreable encoreable=(Encoreable)performance;
        encoreable.performEncore();
    }
}
