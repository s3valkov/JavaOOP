package P03_HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        Set<Field> fieldSet = new TreeSet<>(Comparator.comparing(Field::getName));
        fieldSet.addAll(Arrays.stream(Reflection.class.getDeclaredFields()).collect(Collectors.toList()));

        Method[] methods = P02_GettersSetters.Reflection.class.getDeclaredMethods();
        TreeSet<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
        TreeSet<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));

        for (Method method : methods) {
            if (isGetter(method)) {
                getters.add(method);
            } else if (isSetter(method)) {
                setters.add(method);
            }
        }


        System.out.println("Fields:");
        fieldSet.stream()
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .forEach(field -> System.out.printf("%s must be private!\n", field.getName()));

        System.out.println("Getters:");
        getters.stream()
                .filter(getter -> Modifier.isPublic(getter.getModifiers()))
                .forEach(getter -> System.out.printf("%s must be public!\n", getter.getName()));

        System.out.println("Setters:");
        setters.stream()
                .filter(setter -> Modifier.isPrivate(setter.getModifiers()))
                .forEach(setter -> System.out.printf("%s must be private!\n", setter.getName()));

    }

    private static boolean isSetter(Method method) {
        return method.getName().startsWith("set") && void.class.equals(method.getReturnType());
    }

    private static boolean isGetter(Method method) {
        return method.getName().startsWith("get") && method.getParameterCount() == 0;
    }

}
