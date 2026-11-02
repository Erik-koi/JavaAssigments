public abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
    private final String type;
    private final String fuel;
    private final String color;
    private final double fuelEfficiency;
    private final String efficiencyUnit;

    protected AbstractVehicle(String type, String fuel, String color,
                              double fuelEfficiency, String efficiencyUnit) {
        this.type = type;
        this.fuel = fuel;
        this.color = color;
        this.fuelEfficiency = fuelEfficiency;
        this.efficiencyUnit = efficiencyUnit;
    }

    @Override
    public void start() {
        System.out.println(type + " is starting...");
    }

    @Override
    public void stop() {
        System.out.println(type + " is stopping...");
    }

    @Override
    public void charge() {
        System.out.println("Not possible to charge.");
    }

    @Override
    public double calculateFuelEfficiency() {
        return fuelEfficiency;
    }

    protected String getType() {
        return type;
    }

    protected String getFuel() {
        return fuel;
    }

    protected String getColor() {
        return color;
    }

    protected String getEfficiencyUnit() {
        return efficiencyUnit;
    }

    protected String getBaseInfo() {
        return "Type: " + type + "\n"
                + "Fuel: " + fuel + "\n"
                + "Color: " + color;
    }

    public abstract String getInfo();
}
