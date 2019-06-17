package com.chapter02.concert;

public aspect CriticAspect {
    public CriticAspect(){}

    pointcut performance(): execution(* perform(..));

    after() returning(Object o):performance(){
        System.out.println(criticismEngine.getCriticism());
    }

    after() throwing(Exception e):performance(){

    }

    private CriticismEngine criticismEngine;

    public void setCriticismEngine(CriticismEngine criticismEngine){
        this.criticismEngine=criticismEngine;
    }
}
