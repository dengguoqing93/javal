package future;


import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * ${DESCRIPTION}
 *
 * @author dengguoqing
 * @date 2018-10-23
 */
public class Shop {

    private Random random = new Random();

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        long start = System.nanoTime();
        CompletableFuture.runAsync(() -> System.out.println("开始任务"));
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = (System.nanoTime() - start) / 1000000;
        System.out.println("Invocation returned after " + invocationTime + " msecs");
        try {
            double price = futurePrice.get();
            System.out.println("Price is " + price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long retrievalTime = (System.nanoTime() - start) / 1000000;
        System.out.println("Price returned after " + retrievalTime + "msecs");

    }

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    public Future<Double> getPriceAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}
