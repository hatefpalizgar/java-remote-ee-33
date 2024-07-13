package com.sda.p26_optionals;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main1(String[] args) {

        // Why Optionals?
        User vipUser = new User();

        // String isoCode = vipUser.getAddress().getCountry().getIsoCode(); // this throws NPE (NullPointerException)
        // to avoid NPE in line 9, I should do a null check for every single object

        if (vipUser != null) {
            Address address = vipUser.getAddress();
            if (address != null) {
                Country country = address.getCountry();
                if (country != null) {
                    String isoCode = country.getIsoCode();
                }
            }
        }

        // Instead of doing null checks like above, from Java 8+ we can use Optionals
        String isoCode =
                Optional.ofNullable(vipUser.getAddress())  // Optional<Address>
                        .map(address -> address.getCountry()) // Optional<Country>
                        .map(country -> country.getIsoCode()) // Optional<String>
                        .orElse("no iso code available");

        System.out.println(isoCode);


        Integer number = 5;

        // If number contains a value, anotherNumber will get the same value
        Optional<Integer> anotherNumber = Optional.ofNullable(number);

        // otherwise, if number is null, anotherNumber will become EMPTY (NOT null this time
        // because ofNullable())

        System.out.println(anotherNumber); // prints Optional.empty if number = null

        // Second way of creating an Optional
        // using of() method you have to be sure that its argument is a non-null object
        number = null;
        System.out.println(number); // null
        // Optional<Integer> someNumber = Optional.of(number); // Throws NPE because number is null

        // Let's see what we can do using an Optional

        // We can check if an optional contains a value or not using isPresent()
        if (anotherNumber.isPresent()) {
            System.out.println(anotherNumber.get()); // 5
        } else {
            System.out.println("anotherNumber is empty");
        }

        // You can create optional out of any object or collection of objects
        List<Integer> list = List.of(1, 2, 3, 4);
        Optional<List<Integer>> optionalIntegers = Optional.ofNullable(list);

        // How to create an empty optional using empty() method
        Optional<User> userOpt = Optional.empty();
        System.out.println(userOpt); // Optional.empty
        // System.out.println(userOpt.get()); // throws NoSuchElementException because it's empty


        // TODO: What's the difference between Optional.of() and Optional.ofNullable()

        // How to return default value using Optionals?
        User user = null;
        User userFromOptional = Optional.ofNullable(user)  // Optional.empty
                .orElse(new User()); // if user is null, instead of throwing exception, return a default new User
        System.out.println(userFromOptional); // User {address=null}


        // How to transform Optional values?
        Country estonia = new Country();
        estonia.setIsoCode("EE");

        Address tallinn = new Address();
        tallinn.setCountry(estonia);

        User eeUser = new User();
        eeUser.setAddress(tallinn);

        Optional<User> eeUserOpt = Optional.ofNullable(eeUser);

        Optional<Address> addressOpt = eeUserOpt.map(user1 -> user1.getAddress()); // Optional<Address>>
        System.out.println(addressOpt.get()); // Address{country=Country{isoCode='EE'}}
    }

    public static void main(String[] args) {
        Player player = new Player("John", "john@gmail.com");

        // wrap this object inside an optional: of() / ofNullable()
        Optional<Player> optionalPlayer = Optional.ofNullable(player);

        // unwrap an object inside an optional
        Player extractedPlayer = optionalPlayer.get();

        // check if an optional contains a value or not
        System.out.println(optionalPlayer.isPresent()); // true

        // execute a logic if an optional contains a value
        optionalPlayer.ifPresent(p -> System.out.println(p.getEmail()));

        // return default values if optional is empty
        Optional<Player> emptyPlayerOptional = Optional.empty();
        Player defaultPlayer = emptyPlayerOptional.orElse(new Player("default", "default@gmail.com"));
        System.out.println(defaultPlayer);

        // Transform values inside an optional
        String email = optionalPlayer  // Optional<Player>
                .map(p -> p.getEmail()) // Optional<String>
                .get(); // String


        // flatMap() is useful when you are dealing with objects that have their fields as Optional (BAD
        // PRACTICE! you should never have your fields declared as Optional though).
        // In this case, we Have to use flatMap() instead of map().
        // Let's create a new class called Member with Optional<String> email field and try to get its email
        // using flatMap() as below:

        Member member = new Member("John", Optional.of("john@gmail.com"));
        Optional<Member> memberOptional = Optional.ofNullable(member);

        String extractedEmailUsingMap = memberOptional  // Optional<Member>
                .map(m -> m.getEmail()) // Optional<Optional<String>>
                .get() // Optional<String>
                .get(); // String

        // flatMap()
        String extractedEmailUsingFlatMap = memberOptional
                .flatMap(m -> m.getEmail()).get();

        // Filtering optionals
        Optional<Player> filteredPlayer = optionalPlayer.filter(p -> p.getEmail().contains("gmail"));
        System.out.println(filteredPlayer.isPresent()); // true

        /*
         * NB! Please read more about Optionals here: https://stackify.com/optional-java/
         */
    }

}
