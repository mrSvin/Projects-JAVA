public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40, 2, 10);
        basket.add("Pivo", 30, 3, 12);
        basket.print("Milk");
        
        Arithmetic arithmetic = new Arithmetic();
        arithmetic.sum(10, 26);
        arithmetic.razn(10, 26);
        arithmetic.sup(10, 26);
        arithmetic.sredn(10, 26);
        arithmetic.max(10, 26);
        arithmetic.min(10, 26);

        Printer printer = new Printer();
        printer.appened("kot","kesha",4);
        printer.appened("kot","kesha");
        printer.appened("kesha");
        printer.appened("kot","vasya",6);
        printer.getDocumentsCount();
        printer.getPagesCount();
        printer.print();
        printer.sum_print_document();
        printer.clear();


    }
}
