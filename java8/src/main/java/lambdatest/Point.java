package lambdatest;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * ${DESCRIPTION}
 *
 * @author dengguoqing
 * @date 2018-10-22
 */
public class Point {
    public final static Comparator<Point> COMPARE_BY_X_AND_THEN_Y =
            comparing(Point::getX).thenComparing(Point::getY);
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static List<Point> moveAllPointRightBy(List<Point> points, int x) {
        return points.stream().map(p -> new Point(p.getX() + x, p.getY()))
                .collect(toList());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point moveRightBy(int x) {
        return new Point(this.x + x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            return this.x == ((Point) obj).getX() && this.y == ((Point) obj).getY();
        }
        return false;
    }
}
