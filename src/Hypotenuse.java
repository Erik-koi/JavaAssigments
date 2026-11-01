import java.util.Scanner;

public class Hypotenuse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the first leg: ");
        double a = scanner.nextDouble();

        System.out.print("Enter the length of the second leg: ");
        double b = scanner.nextDouble();

        double c = Math.sqrt(a * a + b * b);

        System.out.printf("The length of the hypotenuse is %.2f%n", c);

        scanner.close();
    }
}