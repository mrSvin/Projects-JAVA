import java.util.Scanner;

public class Elevator {

    private static int currentFloor=1;
    static int minFloor_var=1;
    static int maxFloor_var=1;

    public Elevator(int minFloor, int maxFloor) {
        minFloor_var =minFloor;
        maxFloor_var =maxFloor;
    }

    public static void main(String[] args) {
         Elevator elevator = new Elevator(1,9);
         while (true) {
             System.out.println("Введите номер этажа: ");
             int floor = new Scanner(System.in).nextInt();

             if(floor < minFloor_var || floor > maxFloor_var) {
                 System.out.println("Введен некорректный этаж!");
                 break;
             }

             elevator.move(floor);
         }
    }

    private static void getCurrentFloor() {
        System.out.println("Текущий этаж: " +  currentFloor);
    }
    private static void moveDown() {
        currentFloor--;
        System.out.println("Текущий этаж: " +  currentFloor);
    }
    private static void moveUp() {
        currentFloor++;
        System.out.println("Текущий этаж: " +  currentFloor);
    }

    private static void move(int floor) {
        while (currentFloor<floor) {
            moveUp();
        }
        while (currentFloor>floor) {
            moveDown();
        }

    }

}
