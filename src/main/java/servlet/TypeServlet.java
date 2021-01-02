package servlet;

import dao.TypeDao;
import model.PetType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/TypeServlet")
public class TypeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TypeDao typeDao=new TypeDao();
    public TypeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doGet(request, response);
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        //添加宠物种类
        if("addType".equals(action)){
            addType(request,response);
            //查找宠物种类
        }else if("schType".equals(action)){
            schType(request,response);
            //删除宠物种类
        }else if("delType".equals(action)){
            delType(request,response);
            //修改宠物种类
        }else if("editType".equals(action)){
            editType(request,response);
            //初始化
        }else if("initEditType".equals(action)){
            initEditType(request,response);
        }
    }

    //增加宠物类别
    private void addType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取通过http协议提交过来的数据
        boolean flag=false;
        PrintWriter out = response.getWriter();
        String tName=request.getParameter("tname");
        String tDes=request.getParameter("tdescription");
        String tRemark=request.getParameter("tremark");
        PetType type=new PetType();
        type.setTname(tName);
        type.setDescription(tDes);
        type.setRemarks(tRemark);
            flag=typeDao.checkType(tName);
            if(flag){
                out.println("<script  type='text/javascript'>alert('该类型已存在，请输入新的类型！');</script>");
            }else {
                TypeDao.addType(type);
                schType(request,response);
            }
    }

    //查询宠物类别
    public void schType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String schTypeName = req.getParameter("schTypeName");
        String currPage = req.getParameter("currPage");
        if (currPage == null) {
            currPage = "1";
        }
        int page = Integer.parseInt(currPage);
        List<PetType> list = typeDao.schType(schTypeName);
        // 总条数
        int total = list.size();
        // 每一页多少条
        int pageSize = 10;
        // 获取总页数
        int totalPage = total % pageSize > 0 ? total / pageSize + 1 : total / pageSize;
        if (page > totalPage) {
            page = totalPage;
        }
        if (page < 1) {
            page = 1;
        }
        // 查询数据的开始索引号
        int start = (page - 1) * pageSize;
        List<PetType> typeList = typeDao.getTypeByPage(schTypeName, start, pageSize);
        req.setAttribute("typeList", typeList);
        req.setAttribute("currPage", page);
        req.setAttribute("pageSize", pageSize);
        req.setAttribute("total", total);
        req.setAttribute("totalPage", totalPage);
        req.getRequestDispatcher("type.jsp").forward(req, resp);
    }

    //删除宠物类别
    public void delType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tid = req.getParameter("tid");
        typeDao.delType(Integer.parseInt(tid));
        schType(req, resp);
    }
    /**
     * 修改宠物类别
     */
    public void editType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int tid =Integer.parseInt(req.getParameter("tid")) ;
        String tname = req.getParameter("tname");
        String tdes = req.getParameter("tdescription");
        String remarks=req.getParameter("tremark");
        // 实例化User，进行数据的封装
        PetType type=new PetType();
        type.setTid(tid);
        type.setTname(tname);
        type.setDescription(tdes);
        type.setRemarks(remarks);
        typeDao.editType(type);
        schType(req, resp);
    }
    /**
     * 初始化用户修改
     *
     */
    public void initEditType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tid = req.getParameter("tid");
        PetType type=typeDao.getTypeById(Integer.parseInt(tid));
        req.setAttribute("type",type);
        req.getRequestDispatcher("editType.jsp").forward(req, resp);
    }
}
