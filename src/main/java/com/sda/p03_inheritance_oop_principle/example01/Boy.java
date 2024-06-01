package com.sda.p03_inheritance_oop_principle.example01;

public class Boy extends Dad{
    // child/subclass can have its own fields on top of what inherits
    private String favoriteMusic;

    // call to superclass constructor SHOULD always be the first line in the child constructor
    public Boy(String name, int age, String hairColor, String favoriteMusic) {
        super(name, age, hairColor); // first, create a Dad -> first, create a Person
        this.favoriteMusic = favoriteMusic;
    }


    public void dance() {
        System.out.println("Boy is dancing");
    }

    // since neither Person nor Dad had favoriteMusic field, we have to define getter and setter for it
    public String getFavoriteMusic() {
        return favoriteMusic;
    }

    public void setFavoriteMusic(String favoriteMusic) {
        this.favoriteMusic = favoriteMusic;
    }
}

// Takeaway:
// Every Boy instance is also a Dad instance, is also a Person instance, but the other way around is not correct
