public class Main {
    public static BankAccount bank = new BankAccount();
    public static BankAccount receiver = new BankAccount();

    public static void main(String[] args) {
        System.out.println("Кладем деньги на счет 1");
        bank.put(1500);
        bank.getAmount();

        System.out.println("Отправляем деньги на счет 2");
        bank.send(receiver, 500);
        System.out.println("счет 2:");
        receiver.getAmount();
        System.out.println("счет 1:");
        bank.getAmount();

        bank = new CardAccount();
        bank.put(1500);
        bank.getAmount();
        bank.take(100);
        bank.getAmount();

    }
}
