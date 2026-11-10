import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student(101, "Alex", 20);
        Course course = new Course("CS101", "Introduction to Java", "Jane Smith");
        Enrollment enrollment = new Enrollment(student, course, "2026-11-09");

        try (ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream("enrollments.ser"))) {
            output.writeObject(enrollment);
        }
        System.out.println("Enrollment saved to enrollments.ser.");

        Enrollment restored;
        try (ObjectInputStream input = new ObjectInputStream(
                new FileInputStream("enrollments.ser"))) {
            restored = (Enrollment) input.readObject();
        }

        System.out.println("Enrollment loaded:");
        System.out.println("Student ID: " + restored.getStudent().getId());
        System.out.println("Student name: " + restored.getStudent().getName());
        System.out.println("Student age: " + restored.getStudent().getAge());
        System.out.println("Course code: " + restored.getCourse().getCourseCode());
        System.out.println("Course name: " + restored.getCourse().getCourseName());
        System.out.println("Instructor: " + restored.getCourse().getInstructor());
        System.out.println("Enrollment date: " + restored.getEnrollmentDate());
    }
}
