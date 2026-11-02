class Car {
    protected double speed;
    protected double gasoline;
    protected double tankCapacity;

    Car(double tankCapacity) {
        this.tankCapacity = tankCapacity;
        this.gasoline = tankCapacity;
        this.speed = 0;
    }

    void accelerate() { speed += 5; }
    double getSpeed() { return speed; }
}

class Bus extends Car {
    private int passengers;
    private final int maxPassengers;

    Bus(double tankCapacity, int maxPassengers) {
        super(tankCapacity);
        this.maxPassengers = maxPassengers;
        this.passengers = 0;
    }

    boolean passengerEnter() {
        if (passengers < maxPassengers) {
            passengers++;
            return true;
        }
        return false;
    }

    boolean passengerExit() {
        if (passengers > 0) {
            passengers--;
            return true;
        }
        return false;
    }

    int getPassengers() { return passengers; }
}

public class BusMain {
    public static void main(String[] args) {
        Bus bus = new Bus(200, 3);

        System.out.println("Enter: " + bus.passengerEnter());
        System.out.println("Enter: " + bus.passengerEnter());
        System.out.println("Enter: " + bus.passengerEnter());
        System.out.println("Enter (full): " + bus.passengerEnter());
        System.out.println("Passengers: " + bus.getPassengers());

        System.out.println("Exit: " + bus.passengerExit());
        System.out.println("Passengers: " + bus.getPassengers());
    }
}