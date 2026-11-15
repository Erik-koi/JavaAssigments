public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.add(12);
        calculator.add(7);
        calculator.add(5);
        System.out.println("Sum: " + calculator.getValue());

        calculator.reset();
        System.out.println("After reset: " + calculator.getValue());

        try {
            calculator.add(-3);
        } catch (IllegalArgumentException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
