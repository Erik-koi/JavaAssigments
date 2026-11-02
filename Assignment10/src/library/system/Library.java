package system;

import model.Book;
import model.LibraryMember;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<LibraryMember> members = new ArrayList<>();

    public void addBook(Book book) {
        if (book == null || books.contains(book)) {
            System.out.println("Book cannot be added.");
            return;
        }
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void addMember(LibraryMember member) {
        if (member == null || members.contains(member)) {
            System.out.println("Member cannot be added.");
            return;
        }
        members.add(member);
        System.out.println("Member added: " + member.getName());
    }

    public void borrowBook(LibraryMember member, Book book) {
        if (!isRegistered(member, book)) {
            System.out.println("Member or book is not registered with this library.");
        } else if (book.isBorrowed()) {
            System.out.println("Book is already borrowed.");
        } else if (isReservedByAnotherMember(member, book)) {
            System.out.println("Book is reserved by another member.");
        } else {
            book.setBorrowed(true);
            member.addBorrowedBook(book);
            if (member.hasReservedBook(book)) {
                member.removeReservedBook(book);
                book.setReserved(false);
            }
            System.out.println(member.getName() + " borrowed " + book.getTitle() + ".");
        }
    }

    public void returnBook(LibraryMember member, Book book) {
        if (member == null || book == null || !member.hasBorrowedBook(book)) {
            System.out.println("This member has not borrowed that book.");
            return;
        }
        member.removeBorrowedBook(book);
        book.setBorrowed(false);
        System.out.println(member.getName() + " returned " + book.getTitle() + ".");
    }

    public void reserveBook(LibraryMember member, Book book) {
        if (!isRegistered(member, book)) {
            System.out.println("Member or book is not registered with this library.");
        } else if (book.isBorrowed()) {
            System.out.println("A borrowed book cannot be reserved.");
        } else if (book.isReserved()) {
            System.out.println("Book is already reserved.");
        } else {
            book.setReserved(true);
            member.addReservedBook(book);
            System.out.println("Book reserved successfully.");
        }
    }

    public void cancelReservation(LibraryMember member, Book book) {
        if (member != null && book != null && member.hasReservedBook(book)) {
            member.removeReservedBook(book);
            book.setReserved(false);
            System.out.println("Reservation canceled successfully.");
        } else {
            System.out.println("Book was not reserved by this member.");
        }
    }

    public void displayReservedBooks(LibraryMember member) {
        if (member == null || !members.contains(member)) {
            System.out.println("Member is not registered with this library.");
            return;
        }
        System.out.println("Reserved books for " + member.getName() + ":");
        if (member.getReservedBooks().isEmpty()) {
            System.out.println("No reserved books.");
            return;
        }
        for (Book book : member.getReservedBooks()) {
            System.out.println(book.getTitle());
        }
    }

    private boolean isRegistered(LibraryMember member, Book book) {
        return member != null && book != null
                && members.contains(member) && books.contains(book);
    }

    private boolean isReservedByAnotherMember(LibraryMember member, Book book) {
        for (LibraryMember libraryMember : members) {
            if (libraryMember != member && libraryMember.hasReservedBook(book)) {
                return true;
            }
        }
        return false;
    }
}
