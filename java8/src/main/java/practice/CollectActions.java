package practice;

import dataprocess.Menu;
import moudle.Dish;

import java.util.Comparator;
import java.util.Optional;

import static java.util.stream.Collectors.*;
/**
 * ${DESCRIPTION}
 *
 * @author dengguoqing
 * @date 2018-10-18
 */
public class CollectActions {
    public static void main(String[] args) {
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = Menu.menu.stream().collect(maxBy(dishComparator));
        System.out.println(mostCalorieDish.get());

    }
}
