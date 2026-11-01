import java.util.ArrayList;

class User {
    private String name;
    private int age;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() { return name; }
    int    getAge()  { return age; }

    void borrow(Book book) {
        borrowedBooks.add(book);
    }

    boolean returnBook(Book book) {
        return borrowedBooks.remove(book);
    }

    ArrayList<Book> getBorrowedBooks() { return borrowedBooks; }

    void display() {
        System.out.println("User: " + name + ", Age: " + age
                + ", Borrowed books: " + borrowedBooks.size());
        for (Book b : borrowedBooks) {
            System.out.println("   - " + b.getTitle());
        }
    }
}