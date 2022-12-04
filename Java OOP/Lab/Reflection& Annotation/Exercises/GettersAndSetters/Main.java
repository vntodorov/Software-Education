package ReflectionAndAnnotationLAB.GettersAndSetters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> reflection = Reflection.class;

        Method[] allReflectionMethods = reflection.getDeclaredMethods();

        Arrays.stream(allReflectionMethods)
                .filter(m -> m.getName().startsWith("get"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(m.getName() + " will return class " + m.getReturnType().getName()));

        Arrays.stream(allReflectionMethods)
                .filter(m -> m.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(m.getName() + " and will set field of class " + m.getParameterTypes()[0].getName()));


    }
}
