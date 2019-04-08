package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.BlackBoxInt;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Constructor<?> constructor = BlackBoxInt.class.getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance(0);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] lines = input.split("_");
            String cmd = lines[0];
            int value = Integer.parseInt(lines[1]);

            executeCommand(blackBoxInt, cmd, value);
            printValue(blackBoxInt);

            input = scanner.nextLine();
        }
    }

    private static void executeCommand(BlackBoxInt blackBoxInt, String cmd, int value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = blackBoxInt.getClass().getDeclaredMethod(cmd, int.class);
        method.setAccessible(true);
        method.invoke(blackBoxInt, value);
    }

    private static void printValue(BlackBoxInt blackBoxInt) throws NoSuchFieldException, IllegalAccessException {
        Field field = blackBoxInt.getClass().getDeclaredField("innerValue");
        field.setAccessible(true);
        Integer val = field.getInt(blackBoxInt);
        System.out.println(val);
    }
}
