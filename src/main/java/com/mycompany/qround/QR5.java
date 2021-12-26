
import java.io.*;
import java.nio.file.*;

import java.util.*;

public class QR5 {

    static final String TEMPLATE = "Case #%d: %d";

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Path file = Paths.get("qr5");
        Scanner in = new Scanner(file).useDelimiter("\\s*|\r");
        int caseNumber = in.nextInt();
        for (int i = 1; i <= caseNumber; i++) {
            final int x = in.nextInt();
            final int y = in.nextInt();
            final String input = in.nextLine();
            int sum = 0;
            final char c = 'C';
            final char j = 'J';
            char previous = '?';
            for (int k = 0; k < input.length(); k++) {
                if (input.charAt(k) == c) {

                    if (previous == j) {
                        sum += y;
                    }
                    previous = c;
                } else if (input.charAt(k) == j) {
                    if (previous == c) {
                        sum += x;
                    }
                    previous = j;
                }
            }
            String output = String.format(TEMPLATE, i, sum);
            System.out.println(output);

        }
        in.close();
    }
}
