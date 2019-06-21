package action.chap3;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;

/**
 * 使用指向不可变容器对象的volatile类型引用以缓存最新的结果
 *
 * @author dengguoqing
 * @date 2019/5/15
 */
public class VolatileCacheFactorizer implements Servlet {

    private volatile OneValueCache cache = new OneValueCache(null, null);
    @Override
    public void service(ServletRequest servletRequest,
                        ServletResponse servletResponse) throws ServletException, IOException {
    }




    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }



    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
