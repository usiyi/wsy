package servlet;

import dao.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDao userDao =new UserDao();

    public RegisterServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("uid");
        String password=req.getParameter("pwd");
        System.out.println(username+password);
        String tselect=req.getParameter("tselect");//tselect:“管理员”管理员 或 “客户”
        int type;
        if("管理员".equals(tselect)||tselect==null){//0是管理员，1是客户
            type=0;
        } else {type=1;}
        boolean flag = userDao.checkUname(username);

        Integer msg=0 ;//1表示注册失败；0表示注册成功
        if (flag) {
            msg = 1;
        }
        else{
            if(username.equals("")||password.equals("")){
                out.println("<script type='text/javascript'>");
                out.println("alert('该字段不能为空！');");
                out.println("window.location='register.jsp';");
                out.println("</script>");
            }else{
                //将注册的信息写入数据库
                User user = new User(username,password,type);
                userDao.regUser(user);
//                msg = 0;
            }
        }
        String s = msg.toString();
        System.out.println(s);
        resp.getWriter().print(s);
    }
}