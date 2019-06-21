package action.chap3;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 对数值及其因数分解结果进行缓存的不可变容器类
 *
 * @author dengguoqing
 * @date 2019/5/15
 */
@Immutable
public class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger lastNumber, BigInteger[] lastFactors) {
        this.lastNumber = lastNumber;
        this.lastFactors = Arrays.copyOf(lastFactors, lastFactors.length);
    }

    public BigInteger[] getLastFactors(BigInteger integer) {
        if (lastNumber == null || !lastNumber.equals(integer)) {
            return null;
        } else {
            return Arrays.copyOf(lastFactors, lastFactors.length);
        }
    }
}
