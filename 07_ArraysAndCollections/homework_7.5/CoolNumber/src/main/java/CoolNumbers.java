import net.sf.saxon.om.Item;

import java.util.*;

public class CoolNumbers {

    public static ArrayList<String> numberAuto = new ArrayList<>();

    public static List<String> generateCoolNumbers() {


        String dict = "АВЕКМНОРСТУХ"; //строка содержит все доступные символы

        for (int i = 0; i < 2000001; i++) {
            int number = 1 + (int) (Math.random() * 998);
            int region = 1 + (int) (Math.random() * 198);
            char symbolFirst = dict.charAt((int) (Math.random() * 11));
            char symbolTwo = dict.charAt((int) (Math.random() * 11));
            char symbolThree = dict.charAt((int) (Math.random() * 11));

            numberAuto.add(Character.toString(symbolFirst) + number + symbolTwo + symbolThree + region);
            //System.out.println(numberAuto);
        }
        return numberAuto;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        long begin = System.nanoTime();
        boolean check = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(number)) {
                check = true;
                System.out.println(list.get(i) + " " + number);
            }
        }
        long end = System.nanoTime();
        long time = end-begin;
        System.out.println("Время перебора: " + time);
        return check;

    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        long begin = System.nanoTime();
        int binarySearch = Collections.binarySearch(sortedList, number);
        boolean check = false;
        if (binarySearch == 0) {
            check = true;
        }
        long end = System.nanoTime();
        long time = end-begin;
        System.out.println("Время бинарного поиска: " + time);
        return check;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        long begin = System.nanoTime();
        hashSet.contains(number);
        long end = System.nanoTime();
        long time = end-begin;
        System.out.println("Время бинарного поиска: " + time);

        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {

        long begin = System.nanoTime();
        treeSet.contains(number);
        long end = System.nanoTime();
        long time = end-begin;
        System.out.println("Время бинарного поиска: " + time);

        return treeSet.contains(number);
    }

}
