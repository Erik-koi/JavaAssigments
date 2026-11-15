public class OddEvenPrinterMain {
    public static void main(String[] args) throws InterruptedException {
        int maximum = args.length > 0 ? Integer.parseInt(args[0]) : 20;
        new OddEvenPrinter(maximum).printNumbers();
    }
}
