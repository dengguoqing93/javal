

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * ${DESCRIPTION}
 *
 * @author dengguoqing
 * @date 2018/11/13
 */
public class Demo {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.stream().forEach(x -> System.out.println(x));
        for (Object o : list) {
            System.out.println(o);
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator);
        }
    }
}
