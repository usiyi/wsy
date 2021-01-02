package myFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author siyi
 * @date 2020/12/29 16:53
 */
@WebFilter(filterName = "CountFilter")
public class CountFilter extends HttpServlet implements Filter {
    private static final long serialVersionUID=1L;
    //来访数量
    private int count;

    /**
     *对过滤器的初始值进行处理
     */
    public void init(FilterConfig config) throws javax.servlet.ServletException {
        String param=config.getInitParameter("count");
        //将字符串转换为int
        count=Integer.valueOf(param);

    }

    /**
     *释放资源，对于过滤处理的业务逻辑需要编写到doFilter()方法中，在请求过滤处理后，需要调用chain参数的doFilter()方法,将请求向下传递给下一个过滤器或者目标资源。
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //访问数自增
        count++;
        //将ServletRequest转换成HttpServletRequest
        HttpServletRequest request=(HttpServletRequest)req;
        //获取ServletContext
        ServletContext context=request.getSession().getServletContext();
        //将来访数值放入到ServletContext中
        context.setAttribute("count",count);
        chain.doFilter(req,resp);
    }

    /**
     * 用于过滤器销毁前，完成某些资源的回收
     */
    public void destroy() {

    }

}
