
import java.io.*;
import java.nio.file.*;

import java.util.*;

public class QR3 {

    static class Task implements Comparable<Task> {

        int x;
        int y;

        public Task(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean overlapWith(Task other) {
            return max(x,other.x) < min(y,other.y);
        }
        static int max(int x, int x2){
            return x > x2 ? x :x2;
        }
        static int min(int y, int y2){
            return y < y2 ? y :y2;
        }
        @Override
        public int compareTo(Task task) {
            int diff = x - task.x;
            return diff;

        }

        @Override
        public boolean equals(Object object) {
            if (!(object instanceof Task)) {
                return false;
            }
            Task other = (Task) object;
            return other.x == x && other.y == y;
        }

        @Override
        public int hashCode() {
            return x * 31 + y * 31;
        }

        @Override
        public String toString() {
            return x + "-" + y;
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        final String imp = "IMPOSSIBLE";
        Path file = Paths.get("testset");
        Scanner in = new Scanner(file).useDelimiter("\\s|\r");
        int caseNumber = in.nextInt();
        casei:
        for (int i = 1; i <= caseNumber; i++) {
            SortedSet<Task> cameron = new TreeSet<>();
            SortedSet<Task> jamie = new TreeSet<>();
            StringBuilder result = new StringBuilder();
            in.nextLine();
            int tasksNumber = in.nextInt();
            for (int j = 1; j <= tasksNumber; j++) {
                in.nextLine();
                int start = in.nextInt();
                int end = in.nextInt();
                Task newTask = new Task(start, end);
                if (!tryAdd(newTask, cameron)) {
                    if (!tryAdd(newTask, jamie)) {
                        String s = "Case #%d: %s";
                        s = s = String.format(s, i, imp);
                        System.out.println(s);
                        while (j < tasksNumber) {
                            in.nextLine();
                            j++;
                        }
                        continue casei;
                    } else {
                        result.append('J');
                    }
                } else {
                    result.append('C');
                }

            }
            String s = "Case #%d: %s";
            s = String.format(s, i, result.toString());
            System.out.println(s);
        }
    }

    static boolean tryAdd(Task task, SortedSet<Task> tasks) {
        for (Task t : tasks) {
            if (t.overlapWith(task)) {
                return false;
            }
            if (t.x > task.y) {
                tasks.add(task);
                return true;
            }
        }
        tasks.add(task);
        return true;
    }
}
