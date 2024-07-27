package com.sda.p28_quiz;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // search for members with a specific age

    }

    // version 1
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p: roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    // version 1+
    public static  void printPersonsOlderThanUpgraded(List<Person> roster, int age) {
        Predicate<Person> criteria = p ->  p.getAge() >= age;
        printPersons(roster, criteria);
    }

    // version 2
    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p: roster) {
            if (p.getAge() >= low && p.getAge() <= high) {
                p.printPerson();
            }
        }
    }

    // version 2+
    public static void printPersonsWithinAgeRangeUpgraded (List<Person> roster, int low, int high) {
        Predicate<Person> criteria = (p) -> p.getAge() >= low && p.getAge() <= high;
        printPersons(roster, criteria);
    }

    // version 2.1
    public static void printPersonsEligibleForSelectedService(List<Person> roster) {
        Predicate<Person> criteria = new CheckPersonEligibleForSelectedService();
        printPersons(roster, criteria);
    }

    // version 2.1+ (using anonymous class [Ad-hoc] - imagine Lambda Expression doesn't exist)
    public static void printPersonsEligibleForSelectedServiceUpgraded(List<Person> roster) {
        Predicate<Person> criteria = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge() >= 18 && person.getAge() <= 25;
            }
        };
        printPersons(roster, criteria);
    }

    // version 3
    public static void printPersons(List<Person> roster, Predicate<Person> criteria) {
        for (Person p: roster) {
            if (criteria.test(p)) {
                p.printPerson();
            }
        }
    }
}


class CheckPersonEligibleForSelectedService implements Predicate<Person> {

    @Override
    public boolean test(Person person) {
        return person.getAge() >= 18 && person.getAge() <= 25;
    }
}


class Person {
    enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;


    public int getAge() {
        // ...
        return 1;
    }

    public void printPerson() {
        //...
    }
}
