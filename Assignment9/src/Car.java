public class Car extends AbstractVehicle {
    public Car() {
        super("Car", "Petrol", "Red", 25.0, "miles per gallon");
    }

    @Override
    public String getInfo() {
        return getBaseInfo();
    }
}
