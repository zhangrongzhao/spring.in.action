package com.chapter02.concert;

public class DefaultEncoreable implements Encoreable {
    @Override
    public void performEncore() {
        System.out.println("default encoreable");
    }
}
