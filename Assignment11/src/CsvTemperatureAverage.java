import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class CsvTemperatureAverage {
    private static final String CSV_URL =
            "https://users.metropolia.fi/~jarkkov/temploki.csv";
    private static final String TARGET_DATE = "01.01.2023";

    public static void main(String[] args) throws Exception {
        double sum = 0;
        int measurements = 0;

        URL url = URI.create(CSV_URL).toURL();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
            String headerLine = reader.readLine();
            if (headerLine == null) {
                throw new IllegalStateException("The CSV file is empty.");
            }

            String[] headers = headerLine.replace("\uFEFF", "").split(";", -1);
            int dateColumn = findColumn(headers, "Aika");
            int temperatureColumn = findColumn(headers, "UlkoTalo");

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";", -1);
                if (fields.length <= Math.max(dateColumn, temperatureColumn)) {
                    continue;
                }
                if (!fields[dateColumn].startsWith(TARGET_DATE)) {
                    continue;
                }

                String temperature = fields[temperatureColumn].trim();
                if (!temperature.isEmpty()) {
                    sum += Double.parseDouble(temperature.replace(',', '.'));
                    measurements++;
                }
            }
        }

        if (measurements == 0) {
            throw new IllegalStateException("No temperatures found for " + TARGET_DATE);
        }

        System.out.printf("Average UlkoTalo temperature for %s: %.2f degrees C (%d measurements)%n",
                TARGET_DATE, sum / measurements, measurements);
    }

    private static int findColumn(String[] headers, String columnName) {
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].trim().equals(columnName)) {
                return i;
            }
        }
        throw new IllegalStateException("CSV column not found: " + columnName);
    }
}
