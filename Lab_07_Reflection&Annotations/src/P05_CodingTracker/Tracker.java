package P05_CodingTracker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {

    @Author(name = "Pesho")
    static void printMethodsByAuthor(Class<?> cl) {
        Map<String, List<String>> methodsByAuthor = new HashMap<>();
        Method[] methods = cl.getDeclaredMethods();

        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);

            if (annotation != null) {
                methodsByAuthor.putIfAbsent(annotation.name(), new ArrayList<>());
                methodsByAuthor.get(annotation.name()).add(method.getName() + "()");
            }
        }

        methodsByAuthor.entrySet().stream()
                .forEach(author -> System.out.printf("%s - %s\n"
                        , author.getKey()
                        , String.format(String.join(", "
                                , author.getValue()))));
    }

    @Author(name = "Gosho")
    public static void main(String[] args) {
        printMethodsByAuthor(Tracker.class);
    }


}
