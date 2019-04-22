package dataprocess;

import moudle.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * ${DESCRIPTION}
 *
 * @author dengguoqing
 * @date 2018-10-17
 */

public class StreamProcess {
    public static void main(String[] args) {
        List<String> lowCaloricDishName =
                Menu.menu.stream().filter(d -> d.getCalories() < 400)
                        .sorted(comparing(Dish::getCalories)).map(Dish::getName)
                        .collect(toList());

        System.out.println(lowCaloricDishName);

        List<String> threeHighCaloricDishNames =
                Menu.menu.stream().filter(d -> d.getCalories() > 300)
                        .map(Dish::getName).limit(3).collect(toList());
        System.out.println(threeHighCaloricDishNames);

        List<Integer> numbers = Arrays.asList(4, 5, 3, 9);
        Integer sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        threeHighCaloricDishNames.stream().distinct();

        Optional<Integer> sumOp = numbers.stream().reduce(Integer::sum);
        System.out.println(sumOp.get());

        System.out.println(String.format("最大值为：%d",numbers.stream().reduce
                (Integer::max).orElse(Integer.MAX_VALUE)));

        System.out.println(String.format("最小值为:%d",
                numbers.stream().reduce(Integer::min).orElse(0)));
    }
}
