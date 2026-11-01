import java.util.Scanner;

public class ObsoleteMeasures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Weight (g): ");
        double grams = scanner.nextDouble();


        final double LUOTI_IN_GRAMS = 13.28;
        final double NAULA_IN_GRAMS = 32 * LUOTI_IN_GRAMS;
        final double LEIVISKA_IN_GRAMS = 20 * NAULA_IN_GRAMS;

        int leiviska = (int) (grams / LEIVISKA_IN_GRAMS);
        grams %= LEIVISKA_IN_GRAMS;

        int naula = (int) (grams / NAULA_IN_GRAMS);
        grams %= NAULA_IN_GRAMS;

        double luoti = grams / LUOTI_IN_GRAMS;

        System.out.printf("%.0f grams is %d leiviskä, %d naula, and %.2f luoti.%n",
                grams + leiviska * LEIVISKA_IN_GRAMS + naula * NAULA_IN_GRAMS,
                leiviska, naula, luoti);

        scanner.close();
    }
}