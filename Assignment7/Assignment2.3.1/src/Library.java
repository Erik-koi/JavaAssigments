import java.util.ArrayList;

class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("(no books)");
            return;
        }
        for (int i = 0; i < books.size(); i++) {
            System.out.print((i + 1) + ". ");
            books.get(i).display();
        }
    }

    void findBooksByAuthor(String author) {
        System.out.println("Books by Author \"" + author + "\":");
        boolean found = false;
        for (Book b : books) {
            if (b.getAuthor().equals(author)) {
                b.displayShort();
                found = true;
            }
        }
        if (!found) System.out.println("(none)");
    }

    boolean borrowBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }

    void returnBook(Book book) {
        books.add(book);
    }

    boolean isBookAvailable(String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title)) return true;
        }
        return false;
    }

    double getAverageBookRating() {
        if (books.isEmpty()) return 0.0;
        double sum = 0;
        for (Book b : books) sum += b.getRating();
        return sum / books.size();
    }

    Book getMostReviewedBook() {
        Book best = null;
        int max = -1;
        for (Book b : books) {
            if (b.getReviewCount() > max) {
                max = b.getReviewCount();
                best = b;
            }
        }
        return best;
    }

    void addUser(User user) {
        users.add(user);
    }

    User findUser(String name) {
        for (User u : users) {
            if (u.getName().equals(name)) return u;
        }
        return null;
    }

    void listUsers() {
        if (users.isEmpty()) {
            System.out.println("(no users)");
            return;
        }
        for (User u : users) u.display();
    }

    boolean borrowBookForUser(String title, String userName) {
        User u = findUser(userName);
        if (u == null) return false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                Book b = books.remove(i);
                u.borrow(b);
                return true;
            }
        }
        return false;
    }

    boolean returnBookFromUser(Book book, String userName) {
        User u = findUser(userName);
        if (u == null) return false;
        if (u.returnBook(book)) {
            books.add(book);
            return true;
        }
        return false;
    }
}