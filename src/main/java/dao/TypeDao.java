package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DbUtil;
import model.PetType;

public class TypeDao {
    // 增加宠物类别
    public static int addType(PetType type) {
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        int flag = -1;
        String sql = "INSERT INTO p_type(tname,description,remarks)VALUES(?,?,?)";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, type.getTname());
            psmt.setString(2, type.getDescription());
            psmt.setString(3, type.getRemarks());
            flag = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(psmt, conn);
        }
        return flag;
    }

    /**
     * 檢查类型是否已存在
     *
     */
    public boolean checkType(String typename) {
        boolean flag = false;
        // 连接数据库
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM p_type WHERE tname = ?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, typename);
            rs = psmt.executeQuery();
            while (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(rs, psmt, conn);
        }
        return flag;
    }

    // 查询宠物类别
    public List<PetType> schType(String schTypeName) {
        // 连接数据库
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM p_type WHERE 1 = 1";
        if (!"".equals(schTypeName) && schTypeName != null) {
            sql = sql + " AND tname = '" + schTypeName + "'";
        }
        List<PetType> list = new ArrayList<>();
        try {
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                PetType t = new PetType();
                t.setTid(rs.getInt("tid"));
                t.setTname(rs.getString("tname"));
                t.setDescription(rs.getString("description"));
                t.setRemarks(rs.getString("remarks"));
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(rs, psmt, conn);
        }
        return list;
    }

    // 通过页面查询宠物类型
    public List<PetType> getTypeByPage(String schTypeName, int start,
                                          int pageSize) {
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM p_type WHERE 1 = 1";
        if (!"".equals(schTypeName) && schTypeName != null) {
            sql = sql + " AND tname = '" + schTypeName + "'";
        }
        sql += " LIMIT " + start + "," + pageSize;
        List<PetType> list = new ArrayList<>();
        try {
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                PetType t = new PetType();
                t.setTid(rs.getInt("tid"));
                t.setTname(rs.getString("tname"));
                t.setDescription(rs.getString("description"));
                t.setRemarks(rs.getString("remarks"));
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(rs, psmt, conn);
        }
        return list;
    }

    // 通过编号查询宠物类型
    public PetType getTypeById(int tid) {
        // 连接数据库
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM p_type WHERE tid = ?";
        PetType type = null;
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, tid);
            rs = psmt.executeQuery();
            while (rs.next()) {
                type = new PetType();
                type.setTname(rs.getString("tname"));
                type.setTid(rs.getInt("tid"));
                type.setDescription(rs.getString("description"));
                type.setRemarks(rs.getString("remarks"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(rs, psmt, conn);
        }
        return type;
    }

    // 查询所有宠物类别
    public List<String> schAllType() {
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql;
        sql = "SELECT * FROM p_type  ";
        List<String> type = new ArrayList<>();
        try {
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                type.add(rs.getString("tname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

    // 删除宠物类别
    public void delType(int tid) {
        // 连接数据库
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        String sql = "DELETE FROM p_type WHERE tid = ?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, tid);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(psmt, conn);
        }
    }

    // 修改宠物类别
    public void editType(PetType type) {
        // 连接数据库
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        String sql = "UPDATE p_type SET tname = ?,description = ?,remarks=? WHERE tid = ?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, type.getTname());
            psmt.setString(2, type.getDescription());
            psmt.setString(3, type.getRemarks());
            psmt.setInt(4, type.getTid());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(psmt, conn);
        }
    }
}
