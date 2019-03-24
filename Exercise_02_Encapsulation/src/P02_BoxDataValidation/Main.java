package P02_BoxDataValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double l = Double.parseDouble(reader.readLine());
        double w = Double.parseDouble(reader.readLine());
        double h = Double.parseDouble(reader.readLine());

        try {
            Box box = new Box(l, w, h);
            System.out.println(box.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
