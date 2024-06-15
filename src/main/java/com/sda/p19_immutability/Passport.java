package com.sda.p19_immutability;

import java.util.List;

public final class Passport {
    private final String name;
    private final Nationality nationality;
    private final String passportNumber;
    private final String issueCountry;
    private final List<String> travelHistory;

    public Passport(String name, Nationality nationality, String passportNumber, String issueCountry, List<String> travelHistory) {
        this.name = name;
        this.nationality = new Nationality(nationality.getCountry(), nationality.getCountryCode()); // Defensive copy
        this.passportNumber = passportNumber;
        this.issueCountry = issueCountry;
        this.travelHistory = List.copyOf(travelHistory); // Defensive copy
    }

    public String getName() {
        return name;
    }

    public Nationality getNationality() {
        // Return a defensive copy to prevent mutation from outside
        return new Nationality(nationality.getCountry(), nationality.getCountryCode());
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getIssueCountry() {
        return issueCountry;
    }

    public List<String> getTravelHistory() {
        return travelHistory;
    }



    @Override
    public String toString() {
        return "Passport [" +
                "name='" + name + '\'' +
                ", nationality=" + nationality +
                ", passportNumber='" + passportNumber + '\'' +
                ", issueCountry='" + issueCountry + '\'' +
                ", travelHistory=" + travelHistory +
                ']';
    }
}
