package com.sda.p25_functional_programming.method_references;


/**
 * Method reference is a shorthand notation of a lambda expression to call a method. If your lambda
 * expression is like this:
 *
 * <pre>
 *     str -> System.out.println(str)
 *  </pre>
 * <p>
 * then you can replace it with a method reference like this:
 *
 * <pre>
 *      System.out::println
 *  </pre>
 * <p>
 * The <code>::</code> operator is used in method reference to separate the class or object from the
 * method name <br>
 * <br>
 *
 * <h2>Four types of method references:</h2>
 *
 * <li>Method reference to an instance method of an object – <code> object::instanceMethod </code>
 * <li>Method reference to a static method of a class – <code> Class::staticMethod </code>
 * <li>Method reference to an instance method of an arbitrary object of a particular type – <code>
 * Class::instanceMethod </code>
 * <li>Method reference to a constructor – <code> Class::new </code>
 *
 * @see <a
 * href="https://beginnersbook.com/2017/10/method-references-in-java-8/">method-references-in-java-8</a>
 * <pre></pre>
 * <h1>Method reference to an instance method of an object:</h1>
 */

public class Example01 {
    public static void main(String[] args) {

        Displayable displayable = () -> System.out.println("Hello World");
        //displayable.display(); // print out "Hello World"

        Printer printer = new Printer();

        // anything I put on the right side of this statement that follows the structure
        // of display() method, is correct and works.
        // printer::print is literally referencing print() of printer object
        Displayable displayable2 = printer::print;
        // above code is equivalent to below code:
        // Displayable displayable2 = () -> printer.print();
        // Using printer::print you are telling displayable2 object to use the same logic
        // inside print() method of the printer object and don't expect us to write the lambda expression
        // explicitly

        displayable2.display(); // it will print out : "instance method" because it is referencing print() method of printer object

        // NB! on line 14 above, we are not calling printer.print() method, we are just
        // REFERENCING it; That's why it is called "method reference"
        // the call to print() is made on line 21


        // every method reference can be re-written/replaced with its lambda expression equivalent
        // but not every lambda expression can be written as method reference

        // Method Reference is a syntactic sugar for writing a Lambda expression

    }

    /**
     *
     * @see Example02
     */
}


@FunctionalInterface
interface Displayable {
    void display();
}


class Printer {
    public void print() {
        System.out.println("instance method");
    }
}
