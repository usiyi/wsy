package servlet;

import dao.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends  HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void rememberMe(String rememberMe, String username, String password,
                           HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if ("true".equals(rememberMe)) {
            Cookie cookie = new Cookie("COOKIE_username", username);
            cookie.setPath("/");
            cookie.setMaxAge(365 * 24 * 60 * 60);
            response.addCookie(cookie);

            cookie = new Cookie("COOKIE_password", password);
            cookie.setPath("/");
            cookie.setMaxAge(365 * 24 * 60 * 60);
            response.addCookie(cookie);
        } else {
            // 清空cookie已有的用户名和密码
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("COOKIE_username".equals(cookie.getName())
                            || "COOKIE_password".equals(cookie.getName())) {
                        cookie.setMaxAge(0);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                    }
                }
            }
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        //获取请求
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
        //登录验证
        UserDao userDao = new UserDao();
        User user = new User(username, password);
        int flag = userDao.login(user);
        if (flag==0) {//如果flag=0代表用户是管理员，则请求转发到管理员主页index.jsp；反之客服主页cus_index.jsp
            // success
            // session存贮
            user.setType(0);
            request.getSession().setAttribute("SESSION_user", user);
            // cookie存贮
            rememberMe(rememberMe, username, password, request, response);
            //请求转发到管理员主页面
            request.getRequestDispatcher("index.jsp")
                    .forward(request, response);
        } else if(flag==1){
            user.setType(1);
            request.getSession().setAttribute("SESSION_user", user);
            //请求转发到客户主页面
            request.getRequestDispatcher("cus_index.jsp")
                    .forward(request, response);
        }
        else{
            out.println("<script  type='text/javascript'>");
            out.println("alert('您的用户名或密码错误，请重新输入！');");
            out.println("window.location='login.jsp';");
            out.println("</script>");
        }
    }
}