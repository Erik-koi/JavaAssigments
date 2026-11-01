class Car {

    private double speed;
    private double gasoline;
    private double tankCapacity;

    private boolean cruiseOn;
    private double targetSpeed;
    private static final double MIN_CRUISE = 30;
    private static final double MAX_CRUISE = 120;
    private static final double STEP = 10;

    Car(double tankCapacity, double speed) {
        this.tankCapacity = tankCapacity;
        this.speed = speed;
        this.gasoline = tankCapacity;
        this.cruiseOn = false;
        this.targetSpeed = 0;
    }

    double getSpeed() { return speed; }

    void setTargetSpeed(double target) {
        if (target >= MIN_CRUISE && target <= MAX_CRUISE) {
            this.targetSpeed = target;
        }
    }

    double getTargetSpeed() { return targetSpeed; }

    boolean turnCruiseOn() {
        if (targetSpeed < MIN_CRUISE || targetSpeed > MAX_CRUISE) {
            return false;
        }
        cruiseOn = true;
        while (Math.abs(speed - targetSpeed) > 0.001) {
            if (speed < targetSpeed) {
                speed = Math.min(speed + STEP, targetSpeed);
            } else {
                speed = Math.max(speed - STEP, targetSpeed);
            }
        }
        return true;
    }

    void turnCruiseOff() { cruiseOn = false; }

    boolean isCruiseOn() { return cruiseOn; }
}

public class CruiseMain {
    public static void main(String[] args) {
        Car car = new Car(50, 0);

        car.setTargetSpeed(80);
        System.out.println("Target speed: " + car.getTargetSpeed());

        boolean ok = car.turnCruiseOn();
        if (ok) {
            System.out.println("Cruise control on, speed = " + car.getSpeed());
        } else {
            System.out.println("Cruise control could not be turned on");
        }

        car.turnCruiseOff();
        System.out.println("Cruise control off");
    }
}