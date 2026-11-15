public class Calculator {
    private int value;

    public void reset() {
        value = 0;
    }

    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Only non-negative integers can be added.");
        }
        value += number;
    }

    public int getValue() {
        return value;
    }
}
