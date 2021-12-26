
import java.io.*;

import java.util.*;

public class QR {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseNumber = in.nextInt();
        for (int i = 0; i < caseNumber; i++) {
            int n = in.nextInt();
            int[][] ints = new int[n][n];
            int sum = 0;
            int row = 0;
            int column = 0;
            for (int j = 0; j < n; j++) {
                int counter = 0;
                byte[] tracers = new byte[n];
                boolean rowFlag = false;
                for (int k = 0; k < n; k++) {
                    ints[j][k] = in.nextInt();
                    int index = ints[j][k];
                    if (tracers[index - 1] == 1) {
                        rowFlag = true;
                    } else {
                        tracers[index - 1] = 1;
                    }
                    if (k == j) {
                        sum += ints[j][k];
                    }
                }
                if (rowFlag) {
                    row++;
                }
            }
            for (int j = 0; j < n; j++) {
                boolean columnFlag = false;
                byte[] tracers = new byte[n];
                for (int k = 0; k < n; k++) {
                    int index = ints[k][j];
                    if (tracers[index - 1] == 1) {
                        columnFlag = true;
                    } else {
                        tracers[index - 1] = 1;
                    }
                }
                if (columnFlag) {
                    column++;
                }
            }

            String s = "Case #%d: %d %d %d";
            s = String.format(s, i + 1, sum, row, column);
            System.out.println(s);
            sum = 0;
            row = 0;
            column = 0;
        }
    }
}
