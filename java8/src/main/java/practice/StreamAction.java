package practice;

import moudle.Trader;
import moudle.Transaction;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;


/**
 * ${DESCRIPTION}
 *
 * @author dengguoqing
 * @date 2018-10-18
 */
public class StreamAction {
    static final String CAMBRIDGE = "Cambridge";
    static final String MILAN = "Milan";
    static Trader raoul = new Trader("Raoul", CAMBRIDGE);
    static Trader mario = new Trader("Mario", MILAN);
    static Trader alan = new Trader("Alan", CAMBRIDGE);
    static Trader brian = new Trader("Brian", CAMBRIDGE);

    static List<Transaction> transactions =
            Arrays.asList(new Transaction(brian, 2011, 300),
                          new Transaction(raoul, 2012, 1000),
                          new Transaction(raoul, 2011, 400),
                          new Transaction(mario, 2012, 710),
                          new Transaction(mario, 2012, 700),
                          new Transaction(alan, 2012, 950));

    public static void main(String[] args) {
        Transaction transaction = new Transaction(brian, 2011, 90900);
        Transaction reduce = transactions.stream().filter(t -> t.getValue() == 300).limit(
                1).reduce(
                transaction, (x, y) -> y);
        System.out.println(reduce);


        /*transactions.stream().filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .forEach(t -> System.out.println("2011年的交易，交易金额为:" + t.getValue()));

        System.out.println("------------");
        transactions.stream().map(transaction -> transaction.getTrader().getCity())
                .distinct().forEach(t -> System.out.println("交易员工作过的城市:" + t));

        System.out.println("------------");
        transactions.stream().filter(transaction -> transaction.getTrader().getCity()
                .equals(CAMBRIDGE)).sorted(comparing(t -> t.getTrader().getName()))
                .forEach(t -> System.out.println("来自剑桥的交易员：" + t.getTrader()));
        System.out.println("------------");
        String names = transactions.stream()
                .map(transaction -> transaction.getTrader().getName()).distinct()
                .sorted().collect(joining(","));
        System.out.println(names);*/


    }
}
