public class ParallelNumberSum {
    public static long sum(int[] numbers, int numberOfThreads) throws InterruptedException {
        if (numbers == null) {
            throw new IllegalArgumentException("The numbers array cannot be null.");
        }
        if (numberOfThreads <= 0) {
            throw new IllegalArgumentException("The number of threads must be positive.");
        }
        if (numbers.length == 0) {
            return 0;
        }

        int threadCount = Math.min(numberOfThreads, numbers.length);
        Thread[] threads = new Thread[threadCount];
        long[] partialSums = new long[threadCount];
        int portionSize = numbers.length / threadCount;
        int remainder = numbers.length % threadCount;
        int start = 0;

        for (int i = 0; i < threadCount; i++) {
            int currentThread = i;
            int portionLength = portionSize + (i < remainder ? 1 : 0);
            int end = start + portionLength;
            int portionStart = start;

            threads[i] = new Thread(() -> {
                long partialSum = 0;
                for (int index = portionStart; index < end; index++) {
                    partialSum += numbers[index];
                }
                partialSums[currentThread] = partialSum;
            }, "Sum Thread " + (i + 1));
            start = end;
        }

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        long total = 0;
        for (long partialSum : partialSums) {
            total += partialSum;
        }
        return total;
    }
}
