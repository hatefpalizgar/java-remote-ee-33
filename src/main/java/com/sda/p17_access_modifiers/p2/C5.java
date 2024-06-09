package com.sda.p17_access_modifiers.p2;

import com.sda.p17_access_modifiers.p1.C1;

public class C5 {
    public void aMethod() {
        C1 c1 = new C1();
        System.out.println(c1.publicField);
        // System.out.println(c1.protectedField);
        // System.out.println(c1.defaultField);
        // System.out.println(c1.privateField);

        c1.publicMethod();
        // c1.protectedMethod();
        // c1.defaultMethod();
        // c1.privateMethod();
    }
}
