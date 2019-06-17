package com.concert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"/concert/concert.config.xml"})
//@ContextConfiguration(classes = {ConcertConfig.class})
public class ConcertTest {

    @Autowired
    private Performance performance;


    @Test
    public void encoreTest(){
        Encoreable encoreable=(Encoreable)performance;
        encoreable.performEncore();
        //encoreableIntroducer.performEncore();
    }
}
