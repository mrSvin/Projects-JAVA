public abstract class Client {

    double account = 0;

    public double getAmount() {
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

}
