public class LegalPerson extends Client {
    public void take(double amountToTake) {
        if (amountToTake*1.01 < account) {
            super.take(amountToTake*1.01);
            //account = account - amountToTake*1.01;
        }
    }
}
