public class ElectricMotorcycle extends AbstractVehicle {
    public ElectricMotorcycle() {
        super("Electric Motorcycle", "Electricity", "Green", 0.05, "kWh per kilometer");
    }

    @Override
    public String getInfo() {
        return getBaseInfo();
    }

    @Override
    public void charge() {
        System.out.println("Electric Motorcycle is charging...");
    }
}
