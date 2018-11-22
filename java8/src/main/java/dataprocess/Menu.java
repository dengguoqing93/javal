package dataprocess;

import moudle.Dish;

import java.util.Arrays;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author dengguoqing
 * @date 2018-10-17
 */
public class Menu {
    public static List<Dish> menu =
            Arrays.asList(new Dish("pork", false, 800, Dish.Type.META),
                    new Dish("beef", false, 700, Dish.Type.META),
                    new Dish("chicken", false, 400, Dish.Type.META),
                    new Dish("french fries", true, 530, Dish.Type.OTHER),
                    new Dish("rice", true, 350, Dish.Type.OTHER),
                    new Dish("season fruit", true, 120, Dish.Type.OTHER),
                    new Dish("pizza", true, 550, Dish.Type.OTHER),
                    new Dish("prawns", false, 300, Dish.Type.FISH),
                    new Dish("salmon", false, 450, Dish.Type.FISH));
}
