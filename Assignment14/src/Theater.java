public class Theater {
    private int availableSeats;

    public Theater(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Theater capacity cannot be negative.");
        }
        availableSeats = capacity;
    }

    public synchronized boolean reserveSeats(int ticketCount) {
        if (ticketCount <= 0) {
            throw new IllegalArgumentException("Ticket count must be positive.");
        }
        if (ticketCount > availableSeats) {
            return false;
        }
        availableSeats -= ticketCount;
        return true;
    }

    public synchronized int getAvailableSeats() {
        return availableSeats;
    }
}
