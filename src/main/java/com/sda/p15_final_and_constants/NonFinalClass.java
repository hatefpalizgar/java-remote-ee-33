package com.sda.p15_final_and_constants;

public class NonFinalClass {
    private String name;

    public NonFinalClass(String name) {
        this.name = name;
    }

    public final void finalMethod() {
        // ...
    }

    public void nonFinalMethod() {
        // ...
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
