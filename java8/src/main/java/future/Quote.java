package future;

/**
 * 字符串解析
 *
 * @author dengguoqing
 * @date 2019/10/9
 */
public class Quote {
    private final String shopName;
    private final double price;
    private final Discount.Code discountCoe;

    public Quote(String shopName, double price, Discount.Code discountCoe) {
        this.shopName = shopName;
        this.price = price;
        this.discountCoe = discountCoe;
    }

    public static Quote parse(String s) {
        String[] split = s.split(":");
        String shopNmae = split[0];
        double price = Double.parseDouble(split[2]);
        Discount.Code discountCode = Discount.Code.valueOf(split[2]);
        return new Quote(shopNmae, price, discountCode);
    }

    public String getShopName() {
        return shopName;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getDiscountCoe() {
        return discountCoe;
    }
}
