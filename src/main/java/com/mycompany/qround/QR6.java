
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicInteger;

public class QR6 {

    record Point(int x, int y) {
        public Point compute(Point other) {
            return new Point(Math.max(y, other.y()), Math.min(y, other.y));
        }
        public static Point valueOf(String stringFormat) {
            String[] values = stringFormat.split(",");
            return new Point(Integer.valueOf(values[0]), Integer.valueOf(values[1]));
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        int sum = 0;
        try ( Stream<String> lines = Files.lines(Paths.get("qr6"))) {
            Map<Integer, List<Point>> map = lines.map(Point::valueOf)
                    .distinct()
                    .collect(Collectors.groupingBy(Point::x));
            Map<Point, AtomicInteger> resultMap = new HashMap<>();
            for (Integer x : map.keySet()) {
                List<Point> points = map.get(x);
                for (int i = 0; i < points.size() - 1; i++) {
                    var current = points.get(i);
                    for (int j = i + 1; j < points.size(); j++) {
                        var at = points.get(j);
                        var result = current.compute(at);
                        AtomicInteger value = new AtomicInteger(0);
                        resultMap.putIfAbsent(result, value);
                        resultMap.get(result).getAndIncrement();
                    }
                }
            }
            for (Point p : resultMap.keySet()) {
                int parallelLines = resultMap.get(p).get();
                int numberOfSquars = (parallelLines * (parallelLines - 1)) / 2;
                sum += numberOfSquars;
            }

            System.out.println(sum);
        }
    }
}
