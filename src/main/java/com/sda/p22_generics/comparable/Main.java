package com.sda.p22_generics.comparable;

public class Main {
    public static void main(String[] args) {
       MacBook macBook1 = new MacBook(5);
       MacBook macBook2 = new MacBook(12);

        // display in console the message saying which macbook is faster
        // so, for example if macBook1 is faster, print out "MacBook1 is faster", otherwise
        // print out "MacBook2 is faster"
       if (macBook1.compareTo(macBook2) > 0) {
           System.out.println("MacBook1 is faster");
       } else if (macBook1.compareTo(macBook2) < 0) {
           System.out.println("MacBook2 is faster");
       } else {
           System.out.println("They both are equally performant");
       }
    }
}
