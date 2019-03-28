package P03_ManKind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


            String[] validWorkerData = bufferedReader.readLine().split("\\s+");

            Worker validWorker = new Worker(validWorkerData[0], validWorkerData[1],
                    Double.parseDouble(validWorkerData[2]), Double.parseDouble(validWorkerData[3]));
            System.out.println(validWorker.toString());
        }
}
