import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Bank {

    public TreeMap<String, Long> accountsBank = new TreeMap<>();
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        if (random.nextBoolean() == true) {
            System.out.println("Службой безопасности найдены мошенники! " + fromAccountNum + " и " + toAccountNum + ". Их счета заблокированы.");
            long blockMoneyFrom = accountsBank.get(fromAccountNum) * (-1);
            accountsBank.put(fromAccountNum, blockMoneyFrom);
            long blockMoneyTo = accountsBank.get(toAccountNum) * (-1);
            accountsBank.put(toAccountNum, blockMoneyTo);
        }
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)+++++++++++++++++++
     */
    public String transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        //boolean security = false;
        new Thread(() -> {
            try {
                if (amount > 50_000) {
                    isFraud(fromAccountNum, toAccountNum, amount);
                }
                if (accountsBank.get(fromAccountNum) > 0 && accountsBank.get(toAccountNum) > 0) {
                    if (accountsBank.get(fromAccountNum) >= amount) {

                        //Убавляем деньги
                        synchronized (fromAccountNum) {
                            long takeMoney = accountsBank.get(fromAccountNum) - amount;
                            accountsBank.put(fromAccountNum, takeMoney);
                        }
                        //Добавляем деньги
                        synchronized (toAccountNum) {
                            long putMoney = accountsBank.get(toAccountNum) + amount;
                            accountsBank.put(toAccountNum, putMoney);
                        }

                            System.out.println("Отправлены " + amount + " со счета: " + fromAccountNum + ", на счет: " + toAccountNum);

                    }
                } else {
                    System.out.println("Перевод отменен по причине блокировки одного из аккаунтов!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();
        return String.valueOf(accountsBank.get(fromAccountNum)) + " " + accountsBank.get(toAccountNum);
    }

    public void addAccount(String accName, long money) {

        accountsBank.put(accName, money);

        System.out.println(accName + " cчет открыт! C суммой на счете: " + money);

    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        new Thread(() -> {
            try {
                accountsBank.get(accountNum);
                System.out.println(accountNum + " остаток на счете: " + accountsBank.get(accountNum));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();

        return accountsBank.get(accountNum);

    }

    public long getSumAllAccounts() {
        new Thread(() -> {
            try {
                Long result = accountsBank.entrySet()
                        .stream()
                        .mapToLong(Map.Entry::getValue)
                        .sum();
                System.out.println("Сумма денег на всеx счетах: " + result);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();
        return accountsBank.entrySet()
                .stream()
                .mapToLong(Map.Entry::getValue)
                .sum();
    }


}