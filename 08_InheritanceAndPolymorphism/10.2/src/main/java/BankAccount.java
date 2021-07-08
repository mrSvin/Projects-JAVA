public class BankAccount {

    double account = 0;

    public double getAmount() {
        //TODO: реализуйте метод и удалите todo
        //System.out.println("Остаток account " + account);
        //System.out.println("Остаток accountTwo " + accountTwo);
        System.out.println("Баланс на счете " + account);
        return account;
    }

    public void put(double amountToPut) {
        if (amountToPut > 0) {
            account = account + amountToPut;
            //System.out.println("На счет положено " + amountToPut);
        }
    }

    public void take(double amountToTake) {
        if (amountToTake < getAmount()) {
            account = account - amountToTake;
        } else {
            System.out.println("Недостаточно средств");
        }

    }

    boolean send(BankAccount receiver, double amount) {
        boolean send = false;
        this.take(amount);
        receiver.put(amount);

        System.out.println("Отправляемая сумма " + amount);
        return send;
    }


}
