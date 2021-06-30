    public class CardAccount extends BankAccount {

    public void take(double amountToTake) {
        if (amountToTake<account) {
            account = (account - amountToTake) - amountToTake*0.01;
        }

    }
}
