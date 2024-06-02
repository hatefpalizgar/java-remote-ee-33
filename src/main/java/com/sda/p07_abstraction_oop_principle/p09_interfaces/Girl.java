package com.sda.p07_abstraction_oop_principle.p09_interfaces;

// in Java, you can implement comma separated list of interfaces
// in Java, you can NOT extend multiple classes (multiple-inheritance is avoided for classes)
public class Girl extends Human implements Playable {

    public Girl(String skinColor) {
        super(skinColor);
    }

    @Override
    public void love() {
        System.out.println("showing love to a girl");
    }

    @Override
    public void play() {
        System.out.println("girl is playing");
    }
}
