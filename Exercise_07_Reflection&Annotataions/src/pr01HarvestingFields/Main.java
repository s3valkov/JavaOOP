package pr01HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Field> fieldSet = new LinkedHashSet<>(Arrays.stream(RichSoilLand.class.getDeclaredFields())
                .collect(Collectors.toList()));

        while (true) {
            String cmd = scanner.nextLine();

            if (cmd.equals("HARVEST")) {
                break;
            }

            switch (cmd) {
                case "private":
                    getPrivateFields(fieldSet, RichSoilLand.class);
                    break;
                case "protected":
                    getProtectedFields(fieldSet, RichSoilLand.class);
                    break;
                case "public":
                    getPublicFields(fieldSet, RichSoilLand.class);
                    break;
                case "all":
                    getAllFields(fieldSet, RichSoilLand.class);
                    break;
                default:
                    break;
            }
        }
    }

    private static void getPublicFields(Set<Field> fieldSet, Class<?> clazz) {
        fieldSet.stream().filter(field -> Modifier.isPublic(field.getModifiers())).forEach(field ->
                System.out.printf("public %s %s\n"
                        , field.getType().getSimpleName()
                        , field.getName())
        );
    }

    private static void getProtectedFields(Set<Field> fieldSet, Class<?> clazz) {
        fieldSet.stream().filter(field -> Modifier.isProtected(field.getModifiers())).forEach(field ->
                System.out.printf("protected %s %s\n"
                        , field.getType().getSimpleName()
                        , field.getName())
        );
    }

    private static void getPrivateFields(Set<Field> fieldSet, Class<?> clazz) {
        fieldSet.stream().filter(field -> Modifier.isPrivate(field.getModifiers())).forEach(field ->
                System.out.printf("private %s %s\n"
                        , field.getType().getSimpleName()
                        , field.getName())
        );
    }

    private static void getAllFields(Set<Field> fieldSet, Class<?> clazz) {
        fieldSet.stream().forEach(field ->
                System.out.printf("%s %s %s\n"
                        , Modifier.toString(field.getModifiers())
                        , field.getType().getSimpleName()
                        , field.getName())
        );
    }
}
