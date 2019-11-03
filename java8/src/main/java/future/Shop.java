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

    private String name;

    public Shop(String name) {
        this.name = name;
    }

    public Shop() {
        this.name = "default";
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public String getPrice(String product) {
        double price = calculatePrice(product);

        Discount.Code code = Discount.Code.values()[random.nextInt(
                Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }

    public Future<Double> getPriceAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public String getName() {
        return name;
    }
}
