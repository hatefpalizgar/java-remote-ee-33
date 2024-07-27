package com.sda.java.p27_streams.challenges;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class Task7 {

    public List<String> getTopUsersWithMostFriends(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(
                        user -> user.getFriends().size(),
                        Comparator.reverseOrder())
                )
                .limit(3)
                .map(User::getName)
                .collect(Collectors.toList());
    }

    @Test
    void testGetTopUsersWithMostFriends() {
        User alice = new User("Alice", 20, List.of());
        User bob = new User("Bob", 22, List.of(alice));
        User carol = new User("Carol", 25, Arrays.asList(alice, bob));
        User dave = new User("Dave", 26, Arrays.asList(bob, carol));
        User eve = new User("Eve", 28, List.of(dave, bob, carol));

        List<User> users = Arrays.asList(alice, bob, carol, dave, eve);
        List<String> actual = getTopUsersWithMostFriends(users);

        List<String> expected = Arrays.asList("Carol", "Dave", "Eve");
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.contains("Carol"));
        assertTrue(actual.contains("Dave"));
        assertTrue(actual.contains("Eve"));

    }

    static class User {
        private final String name;
        private final int age;
        private final List<User> friends;

        public User(String name, int age, List<User> friends) {
            this.name = name;
            this.age = age;
            this.friends = friends;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public List<User> getFriends() {
            return friends;
        }
    }
}

