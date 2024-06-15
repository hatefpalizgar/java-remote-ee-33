package com.sda.p19_immutability;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * <h4>Immutability</h4>
 *
 * <p>For a class to be considered immutable, it must meet the following criteria:
 *
 * <ul>
 *   <li><b>Final Class:</b> The class itself must be declared as {@code final} to prevent
 *       subclassing.
 *   <li><b>Final Fields:</b> All fields of the class must be declared as {@code final} to ensure
 *       they are assigned only once.
 *   <li><b>Private Fields:</b> All fields should be private to prevent direct access.
 *   <li><b>No Setter (Mutator) Methods:</b> Provide no methods that modify the object's state after
 *       construction.
 *   <li><b>Immutable Field Types:</b> Prefer immutable field types. For mutable fields (like
 *       arraylist, or mutable class), ensure deep copying during assignment and when returning
 *       them.
 * </ul>
 */

public class Main {
    public static void main(String[] args) {
        // mutate: change
        // mutable: changeable
        // immutable: un-changeable

        List<String> travelHistory = new ArrayList<>();
        travelHistory.add("USA");
        travelHistory.add("Canada");

        Nationality nationality = new Nationality("United States", "US");

        Passport passport = new Passport("John Doe",
                nationality,
                "12345",
                "USA",
                travelHistory);

        System.out.println(passport);

        // Attempt to modify the travel history or other fields of the passport object
        travelHistory.add("Mexico");
        System.out.println(passport.getTravelHistory());

        nationality.setCountry("Japan");
        System.out.println(passport.getNationality());

        Nationality passportNationality = passport.getNationality(); // this will give us a copy of nationality object not itself
        passportNationality.setCountry("Japan"); // this mutates the copy of nationality not the original one
        System.out.println(passport.getNationality()); // this prints the original nationality = United States



    }
}
