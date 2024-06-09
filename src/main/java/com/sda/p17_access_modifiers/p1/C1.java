package com.sda.p17_access_modifiers.p1;

public class C1 {

    // public visibility modifier
    // accessible from any other classes
    public int publicField; //[MOST PERMISSIBLE]

    // protected visibility modifier
    // accessible only by the class itself AND
    // classes in the same package AND
    // its subclasses
    protected int protectedField;

    // default visibility modifier (package-private OR package-access)
    // accessible only by any class in the same package
    int defaultField;

    // private visibility modifier
    // accessible only by the class itself
    private int privateField; // [LEAST PERMISSIBLE]



    public void publicMethod(){}
    protected void protectedMethod(){}
    void defaultMethod(){}
    private void privateMethod(){}

}
