public class ThreadSafeListMain {
    public static void main(String[] args) throws InterruptedException {
        int workerCount = 8;
        int elementsPerWorker = 1_000;
        ThreadSafeList<String> list = new ThreadSafeList<>();
        Thread[] workers = new Thread[workerCount];

        for (int worker = 0; worker < workerCount; worker++) {
            int workerId = worker;
            workers[worker] = new Thread(() -> {
                for (int item = 0; item < elementsPerWorker; item++) {
                    list.add("worker-" + workerId + "-item-" + item);
                }
            }, "List Worker " + (worker + 1));
        }

        for (Thread worker : workers) {
            worker.start();
        }
        for (Thread worker : workers) {
            worker.join();
        }

        int expectedSize = workerCount * elementsPerWorker;
        if (list.size() != expectedSize) {
            throw new IllegalStateException("Expected " + expectedSize
                    + " elements, but found " + list.size() + ".");
        }

        System.out.println("Elements after concurrent additions: " + list.size());
        System.out.println("Removed first element: " + list.remove("worker-0-item-0"));
        System.out.println("Elements after removal: " + list.size());
    }
}
