public class Main {
    private static BankAccount bank = new BankAccount();

    public static void main(String[] args) {
        bank = new BankAccount();
        bank.put(1500);
        bank.getAmount();
        bank.getAmount();
        bank.send("accountTwo", 500);
        bank.send("account", 300);
        bank.getAmount();

    }
}
