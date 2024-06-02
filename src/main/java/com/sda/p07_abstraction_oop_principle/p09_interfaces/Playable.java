package com.sda.p07_abstraction_oop_principle.p09_interfaces;

// 1. interfaces can extend(inherit) each other
// 2. Multiple inheritance is ONLY allowed once both sides are interfaces (parent and child)

import java.io.Serializable;

public interface Playable extends Loveable, Cloneable, Serializable {
    void play();
}
