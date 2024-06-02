package com.sda.p08_polymorphism_oop_principle.overriding;

public class YoutubePlayer extends VodPlayer{
    @Override
    public void play(String title) {
        System.out.println("Youtube is playing " + title);
    }
}
