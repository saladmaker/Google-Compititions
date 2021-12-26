
import java.io.*;
import java.nio.file.*;

import java.util.*;

public class QR4 {

    static final String TEMPLATE = "Case #%d: %d";

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Path file = Paths.get("qr4");
        Scanner in = new Scanner(file).useDelimiter("\\s*|\r");
        int caseNumber = in.nextInt();
        for (int i = 1; i <= caseNumber; i++) {
            int size = in.nextInt();
            int sum = 0;
            int[] list = new int[size];
            for (int j = 0; j < size; j++) {
                list[j] = in.nextInt();
            }
            for (int k = 0; k < list.length - 1; k++) {
                int index = k;
                for (int y = k; y < list.length; y++) {
                    if (list[y] < list[index]) {
                        index = y;
                    }
                }
                int[] sublist = new int[index - k + 1];
                int b = index;
                int c = 0;
                while (b >= k) {
                    sublist[c++] = list[b--];
                }

                for (int e = k, d = 0; e <= index; e++, d++) {
                    list[e] = sublist[d];
                }
                sum = sum + index - k + 1;
            }

            String output = String.format(TEMPLATE, i, sum);
            System.out.println(output);
        }
    }
}
