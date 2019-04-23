package cresla;

import cresla.interfaces.Manager;
import cresla.interfaces.Reactor;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new ManagerImpl();
        String command = scanner.nextLine();

        while (!command.equals("Exit")) {
            String result = "";
            String[] cmdArgs = command.split("\\s+");
            switch (cmdArgs[0]) {
                case "Reactor":
                    result = manager.reactorCommand(Arrays.asList(cmdArgs));
                    break;
                case "Module":
                    result = manager.moduleCommand(Arrays.asList(cmdArgs));
                    break;
                case "Report":
                    result = manager.reportCommand(Arrays.asList(cmdArgs));
            }

            System.out.println(result);
            command = scanner.nextLine();
        }

        System.out.println(manager.exitCommand(Arrays.asList("cm", "dm")));
    }
}
