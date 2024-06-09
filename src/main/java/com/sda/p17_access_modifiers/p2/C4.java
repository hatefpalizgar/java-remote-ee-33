package com.sda.p17_access_modifiers.p2;

import com.sda.p17_access_modifiers.p1.C1;

public class C4 extends C1 {
    public void aMethod() {
        System.out.println(publicField);
        System.out.println(protectedField);
        // System.out.println(defaultField); // not same package
        // System.out.println(privateField);

        publicMethod();
        protectedMethod();
        // defaultMethod();
        // privateMethod();
    }
}
