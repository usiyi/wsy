package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pets;
import model.User;
import model.Purchase;
import model.Sales;
import util.DbUtil;

public class PetDao {
    // 添加宠物信息
    public static boolean addPet(Pets pet) {
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        boolean flag = false;
        String flower_name = pet.getPetname();
        String sql = "INSERT INTO pets (petname,pettype,purprice,selprice,quantity) VALUES (?,?,?,?,?)";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, pet.getPetname());
            psmt.setString(2, pet.getPettype());
            psmt.setFloat(3, pet.getPurPrice());
            psmt.setFloat(4, pet.getSelPrice());
            psmt.setInt(5, pet.getQuantity());
            psmt.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(psmt, conn);
        }
        return flag;
    }

    // 判断宠物是否已经存在
    public static boolean detemineIfPetExist(String petName) {
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        boolean flag = false;
        String sql = "SELECT * FROM pets WHERE petname=? ";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, petName);
            rs = psmt.executeQuery();
            while (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    // 增加宠物进货记录
    public static void addPetPurchaseRecord(Purchase purchase) {
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        String sql = "INSERT INTO purchase (pname,pquantity,pdate) VALUES (?,?,?)";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, purchase.getPname());
            psmt.setInt(2, purchase.getPquantity());
            psmt.setString(3, purchase.getPdate());
            psmt.executeUpdate();
            /*boolean flag = true;
             * if(flag=true){ String
             * sql1="UPDATE flowers SET quantity=? where fid=? ";
             *
             * psmt = conn.prepareStatement(sql1); psmt.setInt(1,0); }
             */
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int fquantity = getQuantity(purchase.getPname());
        fquantity = fquantity + purchase.getPquantity();
        String sql1 = "UPDATE pets SET quantity=? where petname=? ";
        try {
            psmt = conn.prepareStatement(sql1);
            psmt.setInt(1, fquantity);
            psmt.setString(2, purchase.getPname());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 获得当前库宠物数量
    public static int getQuantity(String petName) {
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        int pquantity = 0;
        String sql = "SELECT quantity FROM pets WHERE petname=?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, petName);
            rs = psmt.executeQuery();
            while (rs.next()) {
                pquantity = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pquantity;
    }

    // 增加宠物销售记录
    public static void addPetSalesRecord(Sales sales) {
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        String sql = "INSERT INTO sales(pname,squantity,sdate) VALUES(?,?,?)";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, sales.getPname());
            psmt.setInt(2, sales.getSquantity());
            psmt.setString(3, sales.getSdate());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int pquantity = getQuantity(sales.getPname());
        pquantity = pquantity - sales.getSquantity();
        String sql1 = "UPDATE pets SET quantity=? where petname=? ";
        try {
            psmt = conn.prepareStatement(sql1);
            psmt.setInt(1, pquantity);
            psmt.setString(2, sales.getPname());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 查询宠物信息
    public List<Pets> schPet(String schPetName) {
        // 连接数据库
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM pets WHERE 1 = 1";

        if (!"".equals(schPetName) && schPetName != null) {
            sql = sql + " AND Petname = '" + schPetName + "'";
        }
        List<Pets> list = new ArrayList<>();
        try {
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Pets i = new Pets();
                i.setPetid(rs.getInt("petid"));
                i.setPetname(rs.getString("petname"));
                i.setPettype(rs.getString("pettype"));
                i.setPurPrice(rs.getFloat("purprice"));
                i.setSelPrice(rs.getFloat("selprice"));
                i.setQuantity(rs.getInt("quantity"));
                list.add(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(rs, psmt, conn);
        }
        return list;
    }

    // 顾客浏览宠物信息
    public List<Pets> schPte1(String schPetName) {
        // 连接数据库
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM cus_pets WHERE 1 = 1";
        if (!"".equals(schPetName) && schPetName != null) {
            sql = sql + " AND pname = '" + schPetName + "'";
        }
        List<Pets> list = new ArrayList<>();
        try {
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Pets i = new Pets();
                i.setPetid(rs.getInt("petid"));
                i.setPetname(rs.getString("petname"));
                i.setPettype(rs.getString("pettype"));
                i.setSelPrice(rs.getFloat("selprice"));
                i.setQuantity(rs.getInt("quantity"));
                list.add(i);
                System.out.println(i.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(rs, psmt, conn);
        }
        return list;
    }

    // 查询宠物进货记录
    public List<Purchase> schPetPurchaseRecord() {
        // 连接数据库
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM purchase";
        /*
         * if (!"".equals(schId) ) { sql = sql + " AND pid = '" + schId + "'"; }
         */
        List<Purchase> purchaseRecordList = new ArrayList<>();
        try {
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Purchase pc = new Purchase();
                pc.setPname(rs.getString("pname"));
                pc.setPquantity(rs.getInt("pquantity"));
                pc.setPdate(rs.getString("pdate"));
                purchaseRecordList.add(pc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(rs, psmt, conn);
        }
        return purchaseRecordList;
    }

    // 查询宠物销售记录
    public List<Sales> schPstSalesRecord() {
        // 连接数据库
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM sales ";
        /*
         * if (!"".equals(schId)) { sql = sql + " AND sid = '" + schId + "'"; }
         */
        List<Sales> salesRecordList = new ArrayList<>();
        try {
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Sales sl = new Sales();
                sl.setPname(rs.getString("pname"));
                sl.setSquantity(rs.getInt("squantity"));
                sl.setSdate(rs.getString("sdate"));
                salesRecordList.add(sl);
                System.out.println(sl.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(rs, psmt, conn);
        }
        return salesRecordList;
    }

    //查询所有宠物信息
    public static List<String> schAllPets() {
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql;
        sql = "SELECT * FROM Pets";
        List<String> flowers = new ArrayList<>();
        try {
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                flowers.add(rs.getString("petname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flowers;
    }

    //通过编号查询宠物信息
    public static Pets getPetById(int id) {
        // 连接数据库
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM pets WHERE Petid = ?";
        Pets flower = new Pets();
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, id);
            rs = psmt.executeQuery();
            while (rs.next()) {
                flower.setPetid(rs.getInt("petid"));
                flower.setPetname(rs.getString("petname"));
                flower.setPettype(rs.getString("pettype"));
                flower.setPurPrice(rs.getFloat("purprice"));
                flower.setSelPrice(rs.getFloat("selprice"));
                flower.setQuantity(rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(rs, psmt, conn);
        }
        return flower;
    }

    //通过编号查询进货记录
    public Purchase getPurchaseRecordById(int id) {
        // 连接数据库
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM purchase WHERE pid = ?";
        Purchase pur = new Purchase();
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, id);
            rs = psmt.executeQuery();
            while (rs.next()) {
                pur.setPname(rs.getString("pname"));
                pur.setPquantity(rs.getInt("pquantity"));
                pur.setPdate(rs.getString("pdate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(rs, psmt, conn);
        }
        return pur;
    }

    //通过编号查询销售记录
    public Sales getSalesRecordById(int id) {
        // 连接数据库
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM sales WHERE sid = ?";
        Sales sl = new Sales();
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, id);
            rs = psmt.executeQuery();
            while (rs.next()) {
                sl.setPname(rs.getString("pname"));
                sl.setSquantity(rs.getInt("squantity"));
                sl.setSdate(rs.getString("sdate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(rs, psmt, conn);
        }
        return sl;
    }

    //通过页面查询宠物信息
    public List<Pets> getPetByPage(String schPetName, int start,
                                         int pageSize) {
        // 连接数据库
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM pets WHERE 1 = 1";
        if (!"".equals(schPetName) && schPetName != null) {
            sql = sql + " AND petname = '" + schPetName + "'";
        }
        sql += " LIMIT " + start + "," + pageSize;
        List<Pets> list = new ArrayList<>();
        try {
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Pets p = new Pets();
                p.setPetid(rs.getInt("petid"));
                p.setPetname(rs.getString("petname"));
                p.setPettype(rs.getString("pettype"));
                p.setPurPrice(rs.getFloat("purprice"));
                p.setSelPrice(rs.getFloat("selprice"));
                p.setQuantity(rs.getInt("quantity"));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(rs, psmt, conn);
        }
        return list;
    }

    //通过页面查询进货记录
    public List<Purchase> getPetPurchaseByPage(int start, int pageSize) {
        // 连接数据库
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM purchase";
        /*
         * if (!"".equals(pid) ) { sql = sql + " AND pid = '" + pid + "'"; }
         */
        sql += " LIMIT " + start + "," + pageSize;
        List<Purchase> PurchaseRecordlist = new ArrayList<>();
        try {
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Purchase pur = new Purchase();
                pur.setPid(rs.getInt("pid"));
                pur.setPname(rs.getString("pname"));
                pur.setPquantity(rs.getInt("pquantity"));
                pur.setPdate(rs.getString("pdate"));
                PurchaseRecordlist.add(pur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(rs, psmt, conn);
        }
        return PurchaseRecordlist;
    }

    //通过页面查询销售记录
    public List<Sales> getPetSalesByPage(int start, int pageSize) {
        // 连接数据库
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM sales ";
        sql += " LIMIT " + start + "," + pageSize;
        List<Sales> salesRecordList = new ArrayList<>();
        try {
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Sales sl = new Sales();
                sl.setSid(rs.getInt("sid"));
                sl.setPname(rs.getString("pname"));
                sl.setSquantity(rs.getInt("squantity"));
                sl.setSdate(rs.getString("sdate"));
                salesRecordList.add(sl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(rs, psmt, conn);
        }
        return salesRecordList;
    }

    //删除宠物信息
    public void delPet(int id) {
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        String sql = "DELETE FROM pets WHERE petid = ?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, id);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(psmt, conn);
        }
    }

    //修改宠物信息
    public void editPet(Pets pet) {
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;

        String sql = "UPDATE pets SET petname=?,pettype=?,purprice=?,selprice=?,quantity=? WHERE petid = ?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, pet.getPetname());
            psmt.setString(2, pet.getPettype());
            psmt.setFloat(3, pet.getPurPrice());
            psmt.setFloat(4, pet.getSelPrice());
            psmt.setInt(5, pet.getQuantity());
            psmt.setInt(6, pet.getPetid());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(psmt, conn);
        }
    }
}
