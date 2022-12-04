package ReflectionAndAnnotationLAB.HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> reflection = Reflection.class;

        Field[] fields = Arrays.stream(reflection.getDeclaredFields())
                .sorted(Comparator.comparing(Field::getName))
                .toArray(Field[]::new);

        for (Field field : fields) {
            int modifier = field.getModifiers();
            if (!Modifier.isPrivate(modifier)) {
                System.out.println(field.getName() + " must be private!");
            }
        }

        Method[] getReflectionMethods = Arrays.stream(reflection.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("get"))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        for (Method getter : getReflectionMethods) {
            int modifier = getter.getModifiers();
            if (!Modifier.isPublic(modifier)) {
                System.out.println(getter.getName() + " have to be public!");
            }
        }

        Method[] setReflectionMethods = Arrays.stream(reflection.getDeclaredMethods())
                .filter(m -> m.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        for (Method setter : setReflectionMethods) {
            int modifier = setter.getModifiers();
            if (!Modifier.isPrivate(modifier)) {
                System.out.println(setter.getName() + " have to be private!");
            }
        }


    }
}
