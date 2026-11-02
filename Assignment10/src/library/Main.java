import model.Book;
import model.LibraryMember;
import system.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("The Hobbit", "J. R. R. Tolkien", "978-0547928227");
        Book book2 = new Book("Pride and Prejudice", "Jane Austen", "978-0141439518");
        LibraryMember member = new LibraryMember("Alex", 1);

        library.addBook(book1);
        library.addBook(book2);
        library.addMember(member);

        library.reserveBook(member, book1);
        library.displayReservedBooks(member);
        library.cancelReservation(member, book1);

        library.borrowBook(member, book1);
        library.returnBook(member, book1);

        library.reserveBook(member, book2);
        library.displayReservedBooks(member);
    }
}
