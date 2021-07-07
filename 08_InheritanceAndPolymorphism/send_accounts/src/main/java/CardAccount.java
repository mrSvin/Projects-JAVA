public class CardAccount extends BankAccount {

    public void take(double amountToTake) {
        if (amountToTake<getAmount()*1.01) {
            account = (account - amountToTake) - amountToTake*0.01;
            System.out.println("Списаны деньги с комиссией");
        } else {
            System.out.println("Недостаточно средств");
        }

    }
}
