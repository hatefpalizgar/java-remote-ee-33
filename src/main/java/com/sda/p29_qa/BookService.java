package com.sda.p29_qa;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.ToDoubleFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookService {
    private List<Book> books = new ArrayList<>();

    public void add (Book book) {
        books.add(book);
    }

    public List<Book> getAll() {
        return this.books;
    }

    public Stack<Book> createBookStack(){
        Stack<Book> bookStack = new Stack<>();

        // solution 1
        // Collections.sort(books);

        // solution 2
        // Comparator<Book> comparator = (o1, o2) -> (int)(o1.getPrice() - o2.getPrice());
        // Collections.sort(books, comparator);

        // solution 3
        ToDoubleFunction<Book> keyExtractor = (b) -> b.getPrice();
        Collections.sort(books, Comparator.comparingDouble(keyExtractor));

        for (Book b: books) {
            bookStack.push(b);
        }

        return bookStack;
    }
}

class TestBookService {
    @Test
    void testCreateBookStack() {
        Author author1 = new Author("John", "Smith", 'M');
        Author author2 = new Author("Jessica", "Albana", 'F');
        Author author3 = new Author("Roger", "Moore", 'M');
        Author author4 = new Author("Catherin", "Nadie", 'F');

        Book book1 = new Book("Book 1", 34.5, 2000, List.of(author1), Genre.FICTION);
        Book book2 = new Book("Book 2", 56, 1999, List.of(author2, author3, author4), Genre.TRAVEL);
        Book book3 = new Book("Book 3", 43, 2010, List.of(author4), Genre.COOKING);

        BookService bookService = new BookService();
        bookService.add(book1);
        bookService.add(book2);
        bookService.add(book3);

        Stack<Book> stack = bookService.createBookStack();
        assertEquals(3, stack.size());
        assertEquals("Book 1", stack.get(0).getTitle());
        assertEquals("Book 2", stack.get(2).getTitle());

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}
