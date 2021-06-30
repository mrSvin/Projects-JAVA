public class BankAccount {

    double account = 0;
    double accountTwo = 0;


    public double getAmount() {
        //TODO: реализуйте метод и удалите todo
        //System.out.println("Остаток account " + account);
        //System.out.println("Остаток accountTwo " + accountTwo);
        return account;
    }

    public void put(double amountToPut) {
        if (amountToPut > 0) {
            account = account + amountToPut;
        }
    }

    public void take(double amountToTake) {
        if (amountToTake < account) {
            account = account - amountToTake;
        }

    }

    boolean send(String receiver, double amount) {
        boolean send = false;
        if (receiver.equals("account") ) {
            putAccount(amount);
            takeAccountTwo(amount);
            System.out.println("C accountTwo передано " + amount + " в account");
            System.out.println("Стало на account: " + account);
            System.out.println("Стало на accountTwo: " + accountTwo);
            send = true;
        }
        if (receiver.equals("accountTwo") ) {
            putAccountTwo(amount);
            takeAccount(amount);

            System.out.println("C account передано " + amount + " в accountTwo");
            System.out.println("Стало на accountTwo: " + accountTwo);
            System.out.println("Стало на account: " + account);
            send = true;
        }
        return send;
    }

    public void putAccount(double amountToPut) {
        if (amountToPut > 0  && accountTwo>amountToPut) {
            account = account + amountToPut;
        }
    }

    public void takeAccount(double amountToTake) {
        if (amountToTake < account) {
            account = account - amountToTake - amountToTake*0.01;
        }

    }

    public void putAccountTwo(double amountToPut) {
        if (amountToPut > 0 && account>amountToPut) {
            accountTwo = accountTwo + amountToPut;
        }
    }

    public void takeAccountTwo(double amountToTake) {
        if (amountToTake < accountTwo) {
            accountTwo = accountTwo - amountToTake - amountToTake*0.01;
        }

    }

}
