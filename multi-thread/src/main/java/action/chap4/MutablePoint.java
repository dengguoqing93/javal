package action.chap4;

/**
 * 可变Point类
 *
 * @author dengguoqing
 * @date 2019/5/16
 */
public class MutablePoint {
    public int x, y;

    public MutablePoint() {
        x = 0;
        y = 0;
    }

    public MutablePoint(MutablePoint point) {
        this.x = point.x;
        this.y = point.y;
    }
}
