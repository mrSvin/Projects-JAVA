public class Main {

    public static void main(String[] args) {

        BankAccount bank = new BankAccount();
        BankAccount receiver = new BankAccount();
        operations(bank, receiver);
    }

    private static void operations(BankAccount bank, BankAccount receiver) {
        System.out.println("Кладем деньги на счет 1");
        bank.put(1500);
        bank.getAmount();

        System.out.println("Отправляем деньги на счет 2");
        bank.send(receiver, 500);
        System.out.println("счет 2:");
        receiver.getAmount();
        System.out.println("счет 1:");
        bank.getAmount();

        System.out.println("Отправляем деньги на счет 1");
        receiver.send(bank, 300);
        System.out.println("счет 2:");
        receiver.getAmount();
        System.out.println("счет 1:");
        bank.getAmount();

        System.out.println("\n" + "Проверяем extends с комиссией");
        bank = new CardAccount();
        bank.put(1500);
        bank.getAmount();
        bank.take(100);
        bank.getAmount();
    }


}
