public class LibraryMain {
    public static void main(String[] args) {

        Library library = new Library();

        Book b1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book b2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book b3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        System.out.println("===== Task 1: Library Catalog =====");
        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        System.out.println("Library Catalog:");
        library.displayBooks();

        System.out.println();
        library.findBooksByAuthor("Jane Doe");

        System.out.println();
        System.out.println("===== Task 2: Borrow / Return =====");
        System.out.println("Borrowing \"The Art of Fiction\": "
                + library.borrowBook("The Art of Fiction"));
        System.out.println("Returning \"The Art of Fiction\"...");
        library.returnBook(b3);

        System.out.println();
        System.out.println("===== Task 3: Availability =====");
        System.out.println("Is \"Data Structures and Algorithms\" available? "
                + library.isBookAvailable("Data Structures and Algorithms"));

        System.out.println();
        System.out.println("===== Task 4: Ratings & Reviews =====");
        b1.setRating(4.5);
        b1.addReview("Great intro book");
        b1.addReview("Very helpful");
        b2.setRating(4.0);
        b2.addReview("Solid reference");
        b3.setRating(5.0);
        System.out.println("Ratings and reviews added.");

        System.out.println();
        System.out.println("===== Task 5: Statistics =====");
        System.out.println("Average rating: " + library.getAverageBookRating());
        Book top = library.getMostReviewedBook();
        System.out.println("Most reviewed book: "
                + (top != null ? top.getTitle() : "(none)"));

        System.out.println();
        System.out.println("===== Task 6: Users =====");
        User alice = new User("Alice", 25);
        User bob   = new User("Bob", 30);
        library.addUser(alice);
        library.addUser(bob);

        System.out.println("Alice borrows \"Introduction to Java Programming\": "
                + library.borrowBookForUser("Introduction to Java Programming", "Alice"));
        System.out.println("Bob borrows \"Data Structures and Algorithms\": "
                + library.borrowBookForUser("Data Structures and Algorithms", "Bob"));

        System.out.println();
        System.out.println("Users and their borrowed books:");
        library.listUsers();

        System.out.println();
        System.out.println("Alice returns \"Introduction to Java Programming\": "
                + library.returnBookFromUser(b1, "Alice"));

        System.out.println();
        System.out.println("Users after return:");
        library.listUsers();
    }
}