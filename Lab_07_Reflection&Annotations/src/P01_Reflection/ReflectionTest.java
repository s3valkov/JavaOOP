package P01_Reflection;

import java.lang.reflect.InvocationTargetException;

public class ReflectionTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // name of Class
        Class<Reflection> aClass = Reflection.class;
        System.out.println(aClass);
        String className = aClass.getName();
        System.out.println(className);
        String classSimpleName = aClass.getSimpleName();
        System.out.println(classSimpleName);

        //get superClass
        String superClass = aClass.getSuperclass().getName();
        System.out.println(superClass);

        //Print interfaces
        Class[] interfaces = aClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        //instantiate object
        Reflection ref = aClass.getDeclaredConstructor().newInstance();
        System.out.println(ref);
    }
}
