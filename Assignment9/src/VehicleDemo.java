public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car(),
                new Motorcycle(),
                new Bus(),
                new ElectricCar(),
                new ElectricMotorcycle()
        };

        System.out.println("Vehicle Demonstration");

        for (Vehicle vehicle : vehicles) {
            AbstractVehicle abstractVehicle = (AbstractVehicle) vehicle;
            vehicle.start();
            vehicle.stop();
            System.out.println(abstractVehicle.getType() + " Information:");
            System.out.println(vehicle.getInfo());
            System.out.println("Fuel efficiency: "
                    + vehicle.calculateFuelEfficiency() + " "
                    + abstractVehicle.getEfficiencyUnit());
            abstractVehicle.charge();
            System.out.println();
        }
    }
}
