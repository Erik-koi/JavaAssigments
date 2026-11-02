public class ElectricCar extends AbstractVehicle {
    public ElectricCar() {
        super("Electric Car", "Electricity", "White", 0.18, "kWh per kilometer");
    }

    @Override
    public String getInfo() {
        return getBaseInfo();
    }

    @Override
    public void charge() {
        System.out.println("Electric Car is charging...");
    }
}
