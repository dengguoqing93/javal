/**
 * 二维元组
 *
 * @author dengguoqing
 * @date 2019/3/28
 */
public class Tuple<T, U> {
    private T t;
    private U u;

    public Tuple() {
    }

    public Tuple(T t, U u) {
        this.t = t;
        this.u = u;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public U getU() {
        return u;
    }

    public void setU(U u) {
        this.u = u;
    }
}
