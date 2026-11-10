import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FibonacciCsv {
    private static final int NUMBER_COUNT = 60;
    private static final Path OUTPUT_FILE = Paths.get("fibonacci.csv");

    public static void main(String[] args) throws IOException {
        long first = 0;
        long second = 1;

        try (BufferedWriter writer = Files.newBufferedWriter(
                OUTPUT_FILE, StandardCharsets.UTF_8)) {
            writer.write("Index,Fibonacci");
            writer.newLine();

            for (int index = 0; index < NUMBER_COUNT; index++) {
                writer.write(index + "," + first);
                writer.newLine();

                long next = Math.addExact(first, second);
                first = second;
                second = next;
            }
        }

        System.out.println("Wrote " + NUMBER_COUNT + " Fibonacci numbers to "
                + OUTPUT_FILE.toAbsolutePath());
    }
}
