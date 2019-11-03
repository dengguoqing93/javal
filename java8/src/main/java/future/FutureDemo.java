package future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

/**
 * future示例代码
 *
 * @author dengguoqing
 * @date 2019/10/9
 */
public class FutureDemo {
    private static List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                                                    new Shop("LetsSaveBig"),
                                                    new Shop("MyFavoriteShop"),
                                                    new Shop("BuyItAll"),
                                                    new Shop("Test5"),
                                                    new Shop("BestPrice1"),
                                                    new Shop("LetsSaveBig1"),
                                                    new Shop("MyFavoriteShop1"),
                                                    new Shop("BuyItAll1"),
                                                    new Shop("Test51"));

    public static final Executor EXECUTOR = Executors.newFixedThreadPool(
            Math.min(shops.size(), 100), new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    Thread thread = new Thread(r);
                    thread.setDaemon(true);
                    return thread;
                }
            });

    public static List<String> findPrice(String product) {

        return shops.parallelStream().map(
                shop -> String.format("%s price is %.2f", shop.getName(),
                                      shop.getPrice(product))).collect(
                Collectors.toList());
    }


    public static List<String> findPriceWithAsync(String product) {
        List<CompletableFuture<String>> priceFuture = shops.parallelStream().map(
                shop -> CompletableFuture.supplyAsync(
                        () -> shop.getName() + " price is " + shop.getPrice(
                                product), EXECUTOR)).collect(
                Collectors.toList());


        return priceFuture.stream().map(CompletableFuture::join).collect(
                Collectors.toList());
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(findPrice("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1000000;
        System.out.println("Done in " + duration + " msecs");


        start = System.nanoTime();
        System.out.println(findPriceWithAsync("myPhone27S"));
        duration = (System.nanoTime() - start) / 1000000;
        System.out.println("Done in " + duration + " msecs");
    }
}
