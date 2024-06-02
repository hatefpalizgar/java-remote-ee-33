package com.sda.p08_polymorphism_oop_principle.overriding;

public class NetflixPlayer extends VodPlayer{
    @Override
    public void play(String title) { // HOW
        System.out.println("Netflix is playing " + title);
    }
}
