import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int points = 0;

            for (int i = 1; i <= 10; i++) {
                int a = (int)(Math.random() * 10) + 1;
                int b = (int)(Math.random() * 10) + 1;

                System.out.print(a + " * " + b + " = ");
                int answer = Integer.parseInt(scanner.nextLine());

                if (answer == a * b) {
                    System.out.println("Correct");
                    points++;
                } else {
                    System.out.println("Wrong");
                }
            }

            System.out.println("Score: " + points);

            if (points == 10) {
                System.out.println("Congratulations!");
                break;
            }
        }
    }
}