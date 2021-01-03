package servlet;

import dao.PetDao;
import dao.TypeDao;
import model.Purchase;
import model.Sales;
import model.User;
import model.Pets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/PetServlet")
public class PetServlet {
    private static final long serialVersionUID = 1L;
    private PetDao petDao = new PetDao();
    private TypeDao typeDao = new TypeDao();

    public PetServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        // response.getWriter().append("Served at:
        // ").append(request.getContextPath());
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // doGet(request, response);
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        if ("addPet".equals(action)) {
            addPet(request, response);// 添加宠物
        } else if ("schPet".equals(action)) {
            schPet(request, response);// 浏览宠物
        } else if ("schPet1".equals(action)) {
            schPet1(request, response);// 顾客浏览宠物
        } else if ("delPet".equals(action)) {
            delPet(request, response);// 删除宠物
        } else if ("editPet".equals(action)) {
            editPet(request, response);// 编辑宠物
        }else if ("initEditPet".equals(action)) {
            initEditPet(request, response);
        } else if ("selectType".equals(action)) {
            selectType(request, response);
        } else if ("addPetPurchaseRecord".equals(action)) {
            addPetPurchaseRecord(request, response);// 添加宠物进货记录
        } else if ("addPetSalesRecord".equals(action)) {
            addPetSalesRecord(request, response);// 添加宠物销售记录
        } else if ("schPetPurchaseRecord".equals(action)) {
            schPetPurchaseRecord(request, response);// 查询宠物进货记录
        } else if ("schPetSalesRecord".equals(action)) {
            schPetSalesRecord(request, response);// 查询宠物销售记录
        } else if ("selectPet".equals(action)) {//查看订单
            selectPet(request, response);
        } else if ("selectPet2".equals(action)) {//购买宠物
            selectPet2(request, response);
        } else
            checkPet(request, response);
    }

    // 查询宠物销售记录
    private void schPetSalesRecord(HttpServletRequest request,
                                      HttpServletResponse response) throws ServletException, IOException {
        String currPage = request.getParameter("currPage");
        if (currPage == null) {
            currPage = "1";
        }
        int page = Integer.parseInt(currPage);
        List<Sales> salesRecordList = petDao.schPstSalesRecord();
        // 总条数
        int total = salesRecordList.size();
        // 每一页多少条
        int pageSize = 10;
        // 获取总页数
        int totalPage = total % pageSize > 0 ? total / pageSize + 1 : total
                / pageSize;
        if (page > totalPage) {
            page = totalPage;
        }
        if (page < 1) {
            page = 1;
        }
        User user=(User) request.getSession().getAttribute("SESSION_user");
        int flag=user.getType();
        // 查询数据的开始索引号
        int start = (page - 1) * pageSize;
        List<Sales> salesRecordList1 = petDao.getPetSalesByPage(start,
                pageSize);
        request.setAttribute("outList", salesRecordList1);
        request.setAttribute("currPage", page);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("total", total);
        request.setAttribute("totalPage", totalPage);
        if (flag==1){
            request.getRequestDispatcher("salesRecord.jsp").forward(request,
                    response);
        }else{
            request.getRequestDispatcher("admin_order.jsp").forward(request,
                    response);
        }
    }

    // 查询宠物进货记录
    private void schPetPurchaseRecord(HttpServletRequest request,
                                         HttpServletResponse response) throws ServletException, IOException {
        // int schId = Integer.parseInt(request.getParameter("inBoundId"));
        String currPage = request.getParameter("currPage");
        if (currPage == null) {
            currPage = "1";
        }
        int page = Integer.parseInt(currPage);
        List<Purchase> purchaseRecordList = petDao.schPetPurchaseRecord();
        // 总条数
        int total = purchaseRecordList.size();
        // 每一页多少条
        int pageSize = 10;
        // 获取总页数
        int totalPage = total % pageSize > 0 ? total / pageSize + 1 : total
                / pageSize;
        if (page > totalPage) {
            page = totalPage;
        }
        if (page < 1) {
            page = 1;
        }
        // 查询数据的开始索引号
        int start = (page - 1) * pageSize;
        List<Purchase> purchaseRecordList1 = petDao.getPetPurchaseByPage(
                start, pageSize);
        request.setAttribute("inList", purchaseRecordList1);
        request.setAttribute("currPage", page);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("total", total);
        request.setAttribute("totalPage", totalPage);
        request.getRequestDispatcher("purchaseRecord.jsp").forward(request,
                response);
    }

    // 添加宠物进货记录
    private void addPetPurchaseRecord(HttpServletRequest request,
                                         HttpServletResponse response) throws ServletException, IOException {
        String flowerName = request.getParameter("itemName");
        int pur = Integer.parseInt(request.getParameter("ibnumber"));
        SimpleDateFormat inDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String ind = inDate.format(new Date());
        Purchase p = new Purchase();
        p.setPname(flowerName);
        p.setPquantity(pur);
        p.setPdate(ind);
        PetDao.addPetPurchaseRecord(p);
        schPetPurchaseRecord(request, response);
    }

    // 添加宠物销售记录
    private void addPetSalesRecord(HttpServletRequest request,
                                      HttpServletResponse response) throws ServletException, IOException {
        String flowerName = request.getParameter("itemName");
        int otb = Integer.parseInt(request.getParameter("otbnumber"));
        SimpleDateFormat outDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String otd = outDate.format(new Date());
        Sales sl = new Sales();
        sl.setPname(flowerName);
        sl.setSquantity(otb);
        sl.setSdate(otd);
        PetDao.addPetSalesRecord(sl);
        schPetSalesRecord(request, response);
    }

    // 修改宠物信息
    private void initEditPet(HttpServletRequest request,
                                HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Pets flower = PetDao.getPetById(id);
        request.setAttribute("item", flower);
        request.getRequestDispatcher("editPet.jsp").forward(request,
                response);
    }

    // 修改宠物
    private void editPet(HttpServletRequest request,
                            HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        String flowerName = request.getParameter("itemName");
        String flowerType = request.getParameter("itemType");
        float flowerPPrice = Float.parseFloat(request.getParameter("pPrice"));
        float flowerSPrice = Float.parseFloat(request.getParameter("sPrice"));
        int flowerQuantity = Integer.parseInt(request.getParameter("number"));
        Pets pet = new Pets();
        pet.setPetid(id);
        pet.setPetname(flowerName);
        pet.setPettype(flowerType);
        pet.setPurPrice(flowerPPrice);
        pet.setSelPrice(flowerSPrice);
        pet.setQuantity(flowerQuantity);
        petDao.editPet(pet);
        schPet(request, response);
    }

    // 添加宠物
    private void addPet(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {
        String flowerName = request.getParameter("itemName");
        String flowerType = request.getParameter("itemType");
        float flowerPPrice = Float.parseFloat(request.getParameter("pPrice"));
        float flowerSPrice = Float.parseFloat(request.getParameter("sPrice"));
        int flowerQuantity = Integer.parseInt(request.getParameter("number"));
        Pets flower = new Pets();
        flower.setPetname(flowerName);
        flower.setPettype(flowerType);
        flower.setPurPrice(flowerPPrice);
        flower.setSelPrice(flowerSPrice);
        flower.setQuantity(flowerQuantity);
        if (PetDao.addPet(flower)) {
            schPet(request, response);
        } else {
            response.sendRedirect("pet.jsp");
        }
    }

    // 判断宠物是否已经存在
    public void checkPet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String flowerName = req.getParameter("itemName");
        boolean flag = PetDao.detemineIfPetExist(flowerName);
        PrintWriter out = resp.getWriter();
        out.print(flag);
    }

    // 查找宠物
    public void schPet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String schPetName = req.getParameter("schItemName");
        String currPage = req.getParameter("currPage");
        if (currPage == null) {
            currPage = "1";
        }
        int page = Integer.parseInt(currPage);
        List<Pets> list = petDao.schPet(schPetName);
        // 总条数
        int total = list.size();
        // 每一页多少条
        int pageSize = 10;
        // 获取总页数
        int totalPage = total % pageSize > 0 ? total / pageSize + 1 : total
                / pageSize;
        if (page > totalPage) {
            page = totalPage;
        }
        if (page < 1) {
            page = 1;
        }
        // 查询数据的开始索引号
        int start = (page - 1) * pageSize;
        List<Pets> flowerList = petDao.getPetByPage(schPetName,
                start, pageSize);
        req.setAttribute("flowerList", flowerList);
        req.setAttribute("currPage", page);
        req.setAttribute("pageSize", pageSize);
        req.setAttribute("total", total);
        req.setAttribute("totalPage", totalPage);
        req.getRequestDispatcher("pet.jsp").forward(req, resp);
    }

    // 顾客浏览宠物
    public void schPet1(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String schPetName = req.getParameter("schItemName");
        String currPage = req.getParameter("currPage");
        if (currPage == null) {
            currPage = "1";
        }
        int page = Integer.parseInt(currPage);
        List<Pets> list = petDao.schPte1(schPetName);
        // 总条数
        int total = list.size();
        // 每一页多少条
        int pageSize = 10;
        // 获取总页数
        int totalPage = total % pageSize > 0 ? total / pageSize + 1 : total
                / pageSize;
        if (page > totalPage) {
            page = totalPage;
        }
        if (page < 1) {
            page = 1;
        }
        // 查询数据的开始索引号
        int start = (page - 1) * pageSize;
        List<Pets> flowerList = petDao.getPetByPage(schPetName,
                start, pageSize);
        req.setAttribute("flowerList", flowerList);
        req.setAttribute("currPage", page);
        req.setAttribute("pageSize", pageSize);
        req.setAttribute("total", total);
        req.setAttribute("totalPage", totalPage);
        req.getRequestDispatcher("cus_pet.jsp").forward(req, resp);
    }

    // 删除宠物
    public void delPet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        petDao.delPet(Integer.parseInt(id));
        schPet(req, resp);
    }

    // 选择类别
    public void selectType(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<String> type = typeDao.schAllType();
        req.setAttribute("typeList", type);
        for (String types : type) {
            System.out.println(types);
        }
        req.getRequestDispatcher("addPet.jsp").forward(req, resp);
    }

    public void selectPet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<String> flower = PetDao.schAllPets();
        req.setAttribute("flowerList", flower);
        req.getRequestDispatcher("PetPurchase.jsp").forward(req, resp);
    }

    //购买宠物
    public void selectPet2(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        List<String> flower = PetDao.schAllPets();
//        req.setAttribute("flowerList", flower);

        int id = Integer.parseInt(req.getParameter("id"));
        Pets pet = PetDao.getPetById(id);
        req.setAttribute("item", pet);
        req.getRequestDispatcher("PetSales.jsp").forward(req, resp);
    }
}
