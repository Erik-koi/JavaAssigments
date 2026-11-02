public class Bus extends AbstractVehicle {
    private final int capacity;

    public Bus() {
        super("Bus", "Diesel", "Blue", 6.0, "miles per gallon");
        this.capacity = 40;
    }

    @Override
    public String getInfo() {
        return getBaseInfo() + "\nCapacity: " + capacity + " passengers";
    }
}
