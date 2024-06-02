package com.sda.p08_polymorphism_oop_principle.overriding;

public class HBOPlayer extends VodPlayer{
    @Override
    public void play(String title) {
        System.out.println("HBO is playing " + title);
    }
}
