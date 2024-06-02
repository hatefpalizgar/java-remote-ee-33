package com.sda.p06_aggregation;

/**
 * Aggregation is a type of association that represents a "has-a" relationship. It is a weaker form
 * of relationship compared to composition. In aggregation, the lifetime of the part (e.g.,
 * Notebook) is not strictly managed by the whole (e.g., Backpack). The part can exist independently
 * of the whole.
 */

public class Main {
    public static void main(String[] args) {
        var mathNotebook = new Notebook("Mathematics"); // Java compiler infers the type of mathNotebook by looking on the right side
        var scienceNotebook = new Notebook("Science");
        var historyNotebook = new Notebook("History");

        var backpack = new Backpack(5); // can hold 5 notebooks
        backpack.addNotebook(mathNotebook);
        backpack.addNotebook(scienceNotebook);
        backpack.addNotebook(historyNotebook);

        var student = new Student("Alice", backpack);

        System.out.println("Backpack contains notebooks:");
        for (Notebook notebook : student.getBackpack().getNotebooks()) {
            if (notebook != null)
                System.out.println("- " + notebook.getSubject());  // for one-line if-statement you can omit curly braces
        }
    }
}

// Key Differences of Composition vs. Aggregation:
// - In aggregation, parts (like Notebook) can exist independently (Notebook outside Backpack), and
// can be shared.
// - In composition, parts (like Room) exist only within the whole (Room inside House). They can't
// exist or be shared outside the whole.
