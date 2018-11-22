package charpter2;

import moudle.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * 苹果的筛选
 *
 * @author dengguoqing
 * @date 2018-10-15
 */
public class FilterApple {
    /**
     * 筛选绿色的苹果
     *
     * @param inventory 待筛选的列表
     * @return list 筛选结果
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 筛选指定颜色的苹果
     *
     * @param inventory 待筛选列表
     * @param color     指定颜色
     * @return 筛选后的列表
     */
    public static List<Apple> filterAppleByColor(List<Apple> inventory,
                                                 String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }
}
