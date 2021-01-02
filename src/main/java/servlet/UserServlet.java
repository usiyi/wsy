package servlet;

import com.google.gson.Gson;
import dao.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 4330354917038349691L;
    private UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");

        String username = req.getParameter("name");
        String password=req.getParameter("pid");
        String tselect=req.getParameter("tselect");//tselect:“管理员”管理员 或 “客户”
        int type;
        if("管理员".equals(tselect)){//0是管理员，1是客户
            type=0;
        } else {type=1;}

        boolean flag = userDao.checkUname(username);
        Integer msg ;
        if (flag) {
            msg = 1;
        }
            else{
                //将注册的信息写入数据库
                User user = new User(username,password,type);
                userDao.regUser(user);
            msg = 0;
            }

        String s = msg.toString();
        System.out.println(s);
        resp.getWriter().print(s);
    }
}