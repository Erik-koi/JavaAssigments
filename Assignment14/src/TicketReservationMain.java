import java.util.Random;

public class TicketReservationMain {
    public static void main(String[] args) throws InterruptedException {
        int capacity = args.length > 0 ? Integer.parseInt(args[0]) : 20;
        int customerCount = args.length > 1 ? Integer.parseInt(args[1]) : 15;
        Theater theater = new Theater(capacity);
        Thread[] customers = new Thread[customerCount];
        Random random = new Random(42);

        for (int i = 0; i < customerCount; i++) {
            int customerNumber = i + 1;
            int requestedTickets = random.nextInt(4) + 1;
            customers[i] = new Thread(() -> {
                if (theater.reserveSeats(requestedTickets)) {
                    System.out.println("Customer " + customerNumber + " reserved "
                            + requestedTickets + " tickets.");
                } else {
                    System.out.println("Customer " + customerNumber
                            + " couldn't reserve " + requestedTickets + " tickets.");
                }
            }, "Customer " + customerNumber);
        }

        for (Thread customer : customers) {
            customer.start();
        }
        for (Thread customer : customers) {
            customer.join();
        }

        System.out.println("Available seats: " + theater.getAvailableSeats());
    }
}
