class CoffeeMaker {

    private boolean on;
    private String coffeeType;
    private int coffeeAmount;

    CoffeeMaker() {
        this.on = false;
        this.coffeeType = "normal";
        this.coffeeAmount = 10;
    }

    void turnOn()  { this.on = true; }
    void turnOff() { this.on = false; }

    void setCoffeeType(String type) {
        if (on && (type.equals("normal") || type.equals("espresso"))) {
            this.coffeeType = type;
        }
    }

    void setCoffeeAmount(int amount) {
        if (on && amount >= 10 && amount <= 80) {
            this.coffeeAmount = amount;
        }
    }

    String getCoffeeType()   { return coffeeType; }
    int    getCoffeeAmount() { return coffeeAmount; }
}

public class CoffeeMain {
    public static void main(String[] args) {
        CoffeeMaker maker = new CoffeeMaker();

        maker.turnOn();
        System.out.println("Coffee maker is on");

        maker.setCoffeeType("espresso");
        System.out.println("Coffee type is " + maker.getCoffeeType());

        maker.setCoffeeAmount(50);
        System.out.println("Coffee amount is " + maker.getCoffeeAmount() + " ml");

        maker.turnOff();
        System.out.println("Coffee maker is off");
    }
}