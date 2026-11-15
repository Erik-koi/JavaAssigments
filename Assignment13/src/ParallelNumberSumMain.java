import java.util.Random;

public class ParallelNumberSumMain {
    public static void main(String[] args) throws InterruptedException {
        int numberCount = 100_000;
        int processorCount = Runtime.getRuntime().availableProcessors();
        int threadCount = Math.min(processorCount, numberCount);
        int[] numbers = new int[numberCount];
        Random random = new Random(42);

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1_000);
        }

        long parallelSum = ParallelNumberSum.sum(numbers, threadCount);
        long sequentialSum = 0;
        for (int number : numbers) {
            sequentialSum += number;
        }

        if (parallelSum != sequentialSum) {
            throw new IllegalStateException("Parallel sum does not match sequential sum.");
        }

        System.out.println("Array size: " + numberCount);
        System.out.println("Available processors: " + processorCount);
        System.out.println("Threads used: " + threadCount);
        System.out.println("Sum: " + parallelSum);
    }
}
