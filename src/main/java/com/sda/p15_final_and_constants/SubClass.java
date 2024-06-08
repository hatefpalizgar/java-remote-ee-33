package com.sda.p15_final_and_constants;

public class SubClass extends NonFinalClass{

    public SubClass(String name) {
        super(name);
    }

    // a final method cannot be overridden
//    @Override
//    public final void finalMethod() {
//        // ...
//    }

    // a non-final method can be overridden
    @Override
    public void nonFinalMethod() {
        //...
    }
}
