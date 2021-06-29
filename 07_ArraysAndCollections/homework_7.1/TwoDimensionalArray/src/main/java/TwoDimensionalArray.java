import java.util.Arrays;

public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

        char[][] array = new char[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (i == j || i == size - 1 - j) {
                    array[i][j] = symbol;
                } else {
                    array[i][j] = ' ';
                }
            }
        }
        Arrays.stream(array)
                .forEach(arr -> System.out.println(Arrays.toString(arr)));

        return array;
    }
}
