package com.sda.p26_optionals;

import java.util.Optional;

public class Member {
    private String name;
    private Optional<String> email; // It's a bad practice to have fields of optional
    // optionals are supposed to be used as return types of the methods NOT fields of classes
    // or parameters of methods

    public Member(String name, Optional<String> email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", email=" + email +
                '}';
    }
}
