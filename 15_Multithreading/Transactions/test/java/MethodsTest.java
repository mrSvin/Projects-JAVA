import junit.framework.TestCase;
//For new commit
public class MethodsTest extends TestCase {

    public void testgetBalance() {
        Bank bank = new Bank();
        bank.addAccount("Пумба", 234_000);
        long actual = bank.getBalance("Пумба");
        long expected = 234_000;
        assertEquals(expected, actual);
    }

    public void testgetSumAllAccounts() {
        Bank bank = new Bank();
        //Дрбавляем клиентов в базу и открываем им счет
        bank.addAccount("Пумба", 34_000);
        bank.addAccount("Пятачок", 58_000);
        long actual = bank.getSumAllAccounts();
        long expected = 92_000;
        assertEquals(actual, expected);

    }

    public void testTransfer() throws InterruptedException {
        Bank bank = new Bank();
        //Дрбавляем клиентов в базу и открываем им счет
        bank.addAccount("Пумба", 20_000);
        bank.addAccount("Пятачок", 22_000);
        bank.transfer("Пумба", "Пятачок", 49_000);
        //Проверяем баланс после перевода
        bank.getBalance("Пумба");
        bank.getBalance("Пятачок");
    }

    public void testFraud() throws InterruptedException {
        Bank bank = new Bank();
        bank.addAccount("Пумба", 500_000);
        bank.addAccount("Пятачок", 500_000);
        for (int i = 0; i < 5; i++) {
            bank.isFraud("Пумба", "Пятачок", 50000);
            bank.isFraud("Пятачок", "Пумба", 50000);
        }
        boolean actual = false;
        boolean expected = false;
        assertEquals(actual, expected);
    }

    public void testMultithreading() throws InterruptedException {
        Bank bank = new Bank();
        bank.addAccount("Пумба", 500_000);
        bank.addAccount("Пятачок", 500_000);
        for (int i=0; i<200; i++) {
            bank.transfer("Пумба", "Пятачок", 1);
            bank.transfer("Пятачок", "Пумба", 1);
        }
        Thread.sleep(5000);
        bank.getBalance("Пумба");
        bank.getBalance("Пятачок");
        long actual = bank.getSumAllAccounts() + bank.getBalance("Пумба") + bank.getBalance("Пятачок");
        long expected = 2_000_000;
        assertEquals(actual, expected);

    }


}
