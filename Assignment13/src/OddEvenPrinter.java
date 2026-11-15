public class OddEvenPrinter {
    private final int maximum;
    private int nextNumber = 1;

    public OddEvenPrinter(int maximum) {
        if (maximum < 0) {
            throw new IllegalArgumentException("The maximum must be non-negative.");
        }
        this.maximum = maximum;
    }

    public void printNumbers() throws InterruptedException {
        Thread oddThread = new Thread(() -> printNumbersWithParity(true), "Odd Thread");
        Thread evenThread = new Thread(() -> printNumbersWithParity(false), "Even Thread");

        oddThread.start();
        evenThread.start();
        oddThread.join();
        evenThread.join();
        System.out.println("Printing complete.");
    }

    private synchronized void printNumbersWithParity(boolean odd) {
        while (nextNumber <= maximum) {
            while (nextNumber <= maximum && isOdd(nextNumber) != odd) {
                try {
                    wait();
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                    notifyAll();
                    return;
                }
            }

            if (nextNumber <= maximum) {
                System.out.println(Thread.currentThread().getName() + ": " + nextNumber);
                nextNumber++;
                notifyAll();
            }
        }
    }

    private boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
