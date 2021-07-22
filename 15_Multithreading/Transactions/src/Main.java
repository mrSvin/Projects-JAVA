//For new commit
public class Main {
    public static void main(String[] args) throws InterruptedException {

       // ExecutorService service = Executors.newFixedThreadPool(10);
        Bank bank = new Bank();
        //Дрбавляем клиентов в базу и открываем им счет
        bank.addAccount("Пумба", 234_000);
        bank.addAccount("Пятачок", 458_000);
        //Проверяем методы получения баланса
        bank.getBalance("Пумба");
        bank.getBalance("Пятачок");
        bank.getSumAllAccounts();
        //Реализовываем метод отправки денег
        bank.transfer("Пумба", "Пятачок", 49_000);
        //Проверяем баланс после перевода
        bank.getBalance("Пумба");
        bank.getBalance("Пятачок");
        bank.getSumAllAccounts();
        //Проверяем метод поиска мошенников
        //bank.transfer("Пумба", "Пятачок", 59_000);
        //Проверяем блокировку перевода при заблокированном аккауете
        bank.transfer("Пятачок", "Пумба", 19_000);
        //Проверяем корректность работы многопоточности
        for (int i=0; i<200; i++) {
            bank.transfer("Пумба", "Пятачок", 1);
            bank.transfer("Пятачок", "Пумба", 1);
        }
        Thread.sleep(6000);
        bank.getBalance("Пумба");
        bank.getBalance("Пятачок");
        bank.getSumAllAccounts();


    }
}
