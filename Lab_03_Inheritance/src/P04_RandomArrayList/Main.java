package P04_RandomArrayList;

import java.awt.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        RandomArrayList randomArrayList = new RandomArrayList();
        randomArrayList.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(randomArrayList.getRandomElement());
    }


}
