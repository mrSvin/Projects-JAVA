public class Printer {


    private String queue = "";  //Список документов на печать
    private String name = "";  //Список документов на печать
    private String text = "";  //Список документов на печать
    private int kol_page=0;
    private int sum_kol_page=0;
    private int sum_kol_doc=0;
    private int sum_print_page=0;
    private int sum_print_doc=0;

    public  Printer(String queue, String name, String text, int kol_page) {
    }

    public Printer() {
    }

    public void appened(String name, String text, int kol_page) {
        sum_kol_page=sum_kol_page+kol_page;
        sum_kol_doc++;
        queue =queue + name + "-" + text + "-" + kol_page + " стр. ";
        System.out.println("Добавлено в очередь: " + queue);
    }
    public void appened(String name, String text) {
        queue = queue + name + "-" + text;
        sum_kol_doc++;
        System.out.println("Добавлено в очередь: " + queue);
    }
    public void appened(String text) {
        queue = queue + text;
        sum_kol_doc++;
        System.out.println("Добавлено в очередь: " + queue);
    }
    public void clear() {
        queue ="";
        name = "";  //Список документов на печать
        text = "";  //Список документов на печать
        kol_page=0;
        sum_kol_doc=0;
        sum_kol_page=0;
        System.out.println("Очередь очищена! " + queue);
    }

    public void print() {
        System.out.println("Отправлено на печать " + queue);

        sum_print_page=sum_print_page+sum_kol_page;
        sum_print_doc=sum_print_doc+sum_kol_doc;

        clear();

    }

    public void getPagesCount() {
        System.out.println("Общее количество страниц на печать " + sum_kol_page);
    }

    public void getDocumentsCount() {
        System.out.println("Общее количество добавленных документов " + sum_kol_doc);
    }

    public void sum_print_document() {
        System.out.println("Общее количество распечатанных документов: " + sum_print_doc + " Общее количество распечатанных страниц: " + sum_print_page);
    }

}
