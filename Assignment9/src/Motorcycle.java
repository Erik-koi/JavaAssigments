public class Motorcycle extends AbstractVehicle {
    public Motorcycle() {
        super("Motorcycle", "Gasoline", "Black", 60.0, "miles per gallon");
    }

    @Override
    public String getInfo() {
        return getBaseInfo();
    }
}
