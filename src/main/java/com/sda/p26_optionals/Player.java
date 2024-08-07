package com.sda.p26_optionals;

public class Player {
    private String name;
    private String email;

    public Player(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player {" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
