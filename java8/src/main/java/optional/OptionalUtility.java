package optional;

import java.util.Map;
import java.util.Optional;

/**
 * 利用Optional进行转化的一些操作
 *
 * @author dengguoqing
 * @date 2018-10-22
 */
public class OptionalUtility {
    /**
     * 工具类，私有化构造方法
     */
    private OptionalUtility() {
    }

    /**
     * 根据传入的键，查询map对应的值
     *
     * @param map 查询map
     * @param t   键
     * @param <T> 键类型
     * @param <U> 值类型
     * @return Optional<U>
     */
    public static <T, U> Optional<U> getMapValue(Map<T, U> map, T t) {
        return Optional.ofNullable(map.get(t));
    }

    /**
     * String转为Integer类型
     *
     * @param s string
     * @return Optional
     */
    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
