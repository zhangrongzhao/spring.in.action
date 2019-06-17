//package com.zrz.chapter03;
//
//
//import com.zrz.chapter03.config.DessertConfig;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import static junit.framework.TestCase.assertNotNull;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {DessertConfig.class})
//public class DessertTest {
//
//    private Dessert dessert;
//
//    @Autowired
//    public void setDessert(Dessert dessert){
//        this.dessert = dessert;
//    }
//
//    @Test
//    public void dessertShouldNotBeNull(){
//        assertNotNull(dessert);
//    }
//}
