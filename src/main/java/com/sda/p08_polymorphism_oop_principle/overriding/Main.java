package com.sda.p08_polymorphism_oop_principle.overriding;

import java.util.Scanner;

// 2. Method Overriding (Runtime polymorphism)
//    Method overriding occurs when a child class overrides a method of its parent.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type your player name (Netflix, HBO, Youtube):");
        String input = scanner.nextLine();

        VodPlayer vodPlayer = null;

        if (input.equalsIgnoreCase("Netflix")) {
            vodPlayer = new NetflixPlayer();
        } else if (input.equalsIgnoreCase("HBO")) {
            vodPlayer = new HBOPlayer();
        } else if (input.equalsIgnoreCase("Youtube")) {
            vodPlayer = new YoutubePlayer();
        } else {
            System.out.println("Choose from the available players list");
            return;
        }

        vodPlayer.play("HOW TO DIY A COMPRESSOR_S01");

        scanner.close();
    }
}
