package GenericsLAB.GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {

    public static <T> T[] create(int length, T defaultValue){
        T[] arr = (T[]) Array.newInstance(defaultValue.getClass(), length);

        Arrays.fill(arr, defaultValue);
        return arr;
    }
}
