package moudle;

import net.sf.cglib.beans.BeanCopier;

/**
 * ${DESCRIPTION}
 *
 * @author dengguoqing
 * @date 2018-10-15
 */
public class Apple {
    private String color;
    private double weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Apple apple = new Apple();
        apple.setColor("red");
        apple.setWeight(12);
        Apple apple1=new Apple();
        BeanCopier beanCopier = BeanCopier.create(Apple.class, Apple.class, false);
        beanCopier.copy(apple,apple1,null);
        System.out.println(apple1.getColor());
        apple.setColor("gde");
        System.out.println(apple.getColor());
        System.out.println(apple1.getColor());


    }
}
