public class BankAccount {
    private static int totalAccounts;
    private static int nextAccountNumber = 1001;

    private final int accountNumber;
    private double balance;

    public BankAccount(double startingBalance) {
        if (startingBalance < 0) {
            throw new IllegalArgumentException("Starting balance cannot be negative.");
        }

        accountNumber = nextAccountNumber++;
        balance = startingBalance;
        totalAccounts++;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);

        account1.deposit(500);
        account2.withdraw(800);

        System.out.println("Account " + account1.getAccountNumber()
                + " balance: " + account1.getBalance());
        System.out.println("Account " + account2.getAccountNumber()
                + " balance: " + account2.getBalance());
        System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts());
    }
}
