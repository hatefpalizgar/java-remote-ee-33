package com.sda.p17_access_modifiers.p1;

public class C3 extends C1 {
    public void aMethod() {
        System.out.println(publicField);
        System.out.println(protectedField);
        System.out.println(defaultField); // same package
        // System.out.println(privateField);

        publicMethod();
        protectedMethod();
        defaultMethod();
        // privateMethod();
    }
}
