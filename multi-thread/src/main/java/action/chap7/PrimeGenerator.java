package action.chap7;

import action.commong.ThreadSafe;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用volatile类型的域来保存取消状态
 *
 * @author dengguoqing
 * @date 2019/5/22
 */
@ThreadSafe
public class PrimeGenerator implements Runnable {
    private final List<BigInteger> primes = new ArrayList<>();
    private volatile boolean cancelled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancell() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<>(primes);
    }

    public static void main(String[] args) throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();
        try {
            Thread.sleep(1000);
        }finally {
            generator.cancell();
        }
        List<BigInteger> bigIntegers = generator.get();
        bigIntegers.forEach(System.out::println);

    }
}
