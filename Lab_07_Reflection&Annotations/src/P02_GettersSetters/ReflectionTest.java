package P02_GettersSetters;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class ReflectionTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // name of Class
        Method[] methods = Reflection.class.getDeclaredMethods();
        TreeSet<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
        TreeSet<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));

        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                if (method.getParameterCount() == 0) {
                    getters.add(method);
                }
            } else if (method.getName().startsWith("set")) {
                if (void.class.equals(method.getReturnType())) {
                    setters.add(method);
                }
            }
        }
        System.out.println("Getter:");

        getters.forEach(getter -> System.out.printf("%s will return %s\n", getter.getName(), getter.getReturnType()));
        System.out.println("Setter:");
        setters.forEach(setter -> System.out.printf("%s will return %s\n", setter.getName(), setter.getParameters()[0].getType().getSimpleName()));


    }
}
