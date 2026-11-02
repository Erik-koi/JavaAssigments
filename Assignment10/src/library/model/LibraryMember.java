package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryMember {
    private final String name;
    private final int memberId;
    private final List<Book> borrowedBooks = new ArrayList<>();
    private final List<Book> reservedBooks = new ArrayList<>();

    public LibraryMember(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public List<Book> getBorrowedBooks() {
        return Collections.unmodifiableList(borrowedBooks);
    }

    public void addBorrowedBook(Book book) {
        if (!borrowedBooks.contains(book)) {
            borrowedBooks.add(book);
        }
    }

    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    public boolean hasBorrowedBook(Book book) {
        return borrowedBooks.contains(book);
    }

    public List<Book> getReservedBooks() {
        return Collections.unmodifiableList(reservedBooks);
    }

    public void addReservedBook(Book book) {
        if (!reservedBooks.contains(book)) {
            reservedBooks.add(book);
        }
    }

    public void removeReservedBook(Book book) {
        reservedBooks.remove(book);
    }

    public boolean hasReservedBook(Book book) {
        return reservedBooks.contains(book);
    }
}
