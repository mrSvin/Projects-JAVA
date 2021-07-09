public class IndividualBusinessman extends Client {
    public void put(double amountToPut) {
        if (amountToPut > 0 && amountToPut >= 1000) {
            super.put(amountToPut* 0.995);
            //account = account + amountToPut * 0.995;
        }
        if (amountToPut > 0 && amountToPut < 1000) {
            super.put(amountToPut* 0.99);
            //account = account + amountToPut * 0.99;
        }
    }
}
