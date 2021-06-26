import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();

        int box=0;
        int container=0;
        int truck=0;

        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
        //В каждый грузовик помещается максимум 12 контейнеров. В каждый контейнер — не более 27 ящиков

        box=Integer.parseInt(boxes);
        double checkContainer=box/27.0;
        container=box/27;
        if (checkContainer>container) {
            container=container+1;
        }
        double checkTruck=container/12.0;
        truck=container/12;
        if (checkTruck>truck) {
            truck=truck+1;
        }

        if (truck>1) {
            for (int i=1;i<=truck-1; i++) {
                System.out.println("Грузовик: " + i);
                for (int k=1;k<=12; k++) {
                    System.out.println("\tКонтейнер: " + k);
                    for (int b=1;b<=27; b++) {
                        System.out.println("\t\tЯщик: " + b);
                    }
                }
            }
            System.out.println("Грузовик: " + truck);
            for (int k=1;k<=(container-(truck-1)*12)-1; k++) {
                System.out.println("\tКонтейнер: " + k);
                for (int b=1;b<=27; b++) {
                    System.out.println("\t\tЯщик: " + b);
                }
            }
            System.out.println("\tКонтейнер: " + (container-(truck-1)*12));
            for (int b=1;b<=box-(container-1)*27; b++) {
                System.out.println("\t\tЯщик: " + b);
            }

        } else {
            System.out.println("Грузовик: " + 1);
            if (container==1) {
                System.out.println("\tКонтейнер: " + 1);
            }
            if (container==1) {
                for (int i=1; i<=box; i++) {
                    System.out.println("\t\tЯщик: " + i);
                }
            }
        }

        System.out.println("Необходимо:");
        System.out.println("грузовиков - " + truck + " шт.");
        System.out.println("контейнеров - " + container + " шт.");


    }

}
