package com.sda.p07_abstraction_oop_principle.p09_interfaces;


// You can NEVER instantiate interfaces or abstract classes
public class Main {
    public static void main(String[] args) {
        Girl girl = new Girl("White");
        Cat kittie = new Cat(2, "blue");

        // WHAT: love()
        // HOW: the implementation of love() which is different for Girl and Cat
        showLove(girl); // showing love to a girl
        showLove(kittie); // showing love to a cat


        // Possible statements (thanks to polymorphism)
        Girl julie = new Girl("Brunette");
//        Loveable julie = new Girl("Brunette");
//        Playable julie = new Girl("Brunette");
//        Human julie = new Girl("Brunette");

        Cat mew = new Cat(3, "black");
//        Loveable mew = new Cat(3, "black");
//        Animal mew = new Cat(3, "black");

    }


    public static void showLove(Loveable loveable) {
        // because of Loveable interface (contract)
        // we are %100 sure that any Loveable object
        // has love() method
        loveable.love();  // WHAT

        // the answer HOW is specified during runtime by each concrete implementation of
        // Loveable (i.e. Girl or Cat)
    }


//    You no longer need to have separate methods for each separate type of class because
//    Now, interfaces are helping you to abstract away WHAT from HOW
//    public static void showLove(Girl girl) {
//        girl.love();
//    }
//
//    public static void showLove(Cat cat) {
//        cat.love();
//    }


}
