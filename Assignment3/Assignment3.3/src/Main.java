import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Start: ");
        int start = Integer.parseInt(scanner.nextLine());
        System.out.print("End: ");
        int end = Integer.parseInt(scanner.nextLine());

        for (int n = start; n <= end; n++) {
            boolean prime = true;

            if (n < 2) {
                prime = false;
            }

            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    prime = false;
                }
            }

            if (prime) {
                System.out.println(n);
            }
        }
    }
}