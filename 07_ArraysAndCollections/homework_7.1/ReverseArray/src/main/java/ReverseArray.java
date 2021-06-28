import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseArray {



    //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
    public static String[] reverse (String[] strings){

        List<Object> list = Arrays.asList(strings);
        Collections.reverse(list);
        System.out.println(list);

        return strings;
    }
}
