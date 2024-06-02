package com.sda.p06_aggregation;

// Every backpack is an aggregate of notebooks
public class Backpack {
    private Notebook[] notebooks; // The backpack HAS-A bunch of Notebook
    private int count;

    public Backpack(int capacity) {
        notebooks = new Notebook[capacity];
        count = 0;
    }

    public void addNotebook(Notebook notebook) {
        if (count < notebooks.length) {
            notebooks[count] = notebook;
            count++;
        } else {
            System.out.println("Backpack is full, cannot add more notebooks");
        }
    }

    public Notebook[] getNotebooks() {
        return notebooks;
    }
}
