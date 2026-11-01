class Car {

    private double speed;
    private double gasoline;
    private double tankCapacity;

    Car() {
        this.speed = 0;
        this.gasoline = 0;
        this.tankCapacity = 0;
    }

    Car(double tankCapacity, double speed) {
        this.tankCapacity = tankCapacity;
        this.speed = speed;
        this.gasoline = tankCapacity;
    }

    double getSpeed() {
        return speed;
    }
}

public class CarMain {
    public static void main(String[] args) {
        Car car = new Car(50, 0);
        System.out.println("Car created: tank = 50, speed = " + car.getSpeed());
    }
}