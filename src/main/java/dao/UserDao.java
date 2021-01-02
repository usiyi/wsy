package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import util.DbUtil;

public class UserDao {
    /**
     * 检查用户
     *
     * @param uid
     */
  /*  public boolean checkUn(String uid) {
        boolean flag = false;
        // 连接数据库
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM user WHERE uid = ?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, uid);
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
    }*/

    /**
     * 檢查用戶是否已被註冊
     *
     */
    public boolean checkUname(String uname) {
        boolean flag = false;
        // 连接数据库
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM user WHERE username = ?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, uname);
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

    /**
     * 登录用户
     */
    public int login(User user) {
        int flag = -1;
        // 连接数据库
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "SELECT type FROM user WHERE username = ? AND password = ?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, user.getUsername());
            psmt.setString(2, user.getPassword());
            rs = psmt.executeQuery();
            while (rs.next()) {
                flag = rs.getInt("type");//0管理員 1顧客
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(rs, psmt, conn);
        }
        return flag;
    }

    /**
     * 注册用户
     *
     * @param user
     */
    public void regUser(User user) {
        // 连接数据库
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        String sql = "INSERT INTO user (uid,username,password,type) VALUES (?,?,?,?)";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, user.getUid());
            psmt.setString(2, user.getUsername());
            psmt.setString(3, user.getPassword());
            psmt.setInt(4, user.getType());
            psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(psmt, conn);
        }
    }

    /**
     * 删除用户
     *
     * @param uid
     */
    public void delUser(int uid) {
        // 连接数据库
        Connection conn = DbUtil.getConn();
        PreparedStatement psmt = null;
        String sql = "DELETE FROM user WHERE uid = ?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, uid);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库的连接
            DbUtil.close(psmt, conn);
        }
    }
}
