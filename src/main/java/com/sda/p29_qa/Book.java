package com.sda.p29_qa;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Book implements Comparable<Book> {
    private String title;
    private double price; // BigDecimal
    private int yearOfRelease;
    private List<Author> authors;
    private Genre genre;


    @Override
    public int compareTo(Book o) {
        return (int)(this.price - o.getPrice());
    }
}
