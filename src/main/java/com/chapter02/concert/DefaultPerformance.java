package com.chapter02.concert;

public class DefaultPerformance implements Performance {
    @Override
    public void perform() {
        System.out.println("default performance");
    }
}
