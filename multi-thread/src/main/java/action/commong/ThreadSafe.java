package action.commong;

import java.lang.annotation.*;

/**
 * 线程安全
 *
 * @author dengguoqing
 * @date 2019/5/16
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ThreadSafe {
}
