import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private int year;

    private double rating;
    private ArrayList<String> reviews = new ArrayList<>();

    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.rating = 0.0;
    }

    String getTitle()  { return title; }
    String getAuthor() { return author; }
    int    getYear()   { return year; }

    void setRating(double rating) {
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        }
    }

    double getRating() { return rating; }

    void addReview(String review) {
        if (review != null && !review.isEmpty()) {
            reviews.add(review);
        }
    }

    int getReviewCount() { return reviews.size(); }

    void display() {
        System.out.println("Title: \"" + title + "\", Author: \"" + author
                + "\", Year: " + year);
    }

    void displayShort() {
        System.out.println("Title: \"" + title + "\", Year: " + year);
    }
}