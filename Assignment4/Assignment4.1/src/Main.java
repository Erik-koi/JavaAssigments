import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstNames = {"Anna", "John", "Maria", "Peter", "Sofia", "Alex"};
        String[] lastNames = {"Smith", "Johnson", "Brown", "Wilson", "Taylor", "Lee"};

        System.out.print("How many names? ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            int firstIndex = (int)(Math.random() * firstNames.length);
            int lastIndex = (int)(Math.random() * lastNames.length);

            System.out.println(firstNames[firstIndex] + " " + lastNames[lastIndex]);
        }
    }
}