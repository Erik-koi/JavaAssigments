class Car {
    protected double speed;
    protected double gasoline;
    protected double tankCapacity;
    protected double acceleration;
    protected double consumption;

    Car(double tankCapacity) {
        this.tankCapacity = tankCapacity;
        this.gasoline = tankCapacity;
        this.speed = 0;
        this.acceleration = 5;
        this.consumption = 1;
    }

    void accelerate() {
        speed += acceleration;
        gasoline -= consumption;
        if (gasoline < 0) gasoline = 0;
    }

    void decelerate() {
        speed -= acceleration;
        if (speed < 0) speed = 0;
    }

    double getSpeed()    { return speed; }
    double getGasoline() { return gasoline; }
}

class SportsCar extends Car {
    SportsCar(double tankCapacity) {
        super(tankCapacity);
        this.acceleration = 15;
        this.consumption = 3;
    }
}

public class SportsCarMain {
    public static void main(String[] args) {
        Car normal = new Car(50);
        SportsCar sport = new SportsCar(50);

        for (int i = 0; i < 3; i++) {
            normal.accelerate();
            sport.accelerate();
        }

        System.out.println("Ordinary car -> speed: " + normal.getSpeed()
                + ", gasoline: " + normal.getGasoline());
        System.out.println("Sports car   -> speed: " + sport.getSpeed()
                + ", gasoline: " + sport.getGasoline());
    }
}