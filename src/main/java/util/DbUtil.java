package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {
	/**
	 * 1.引入数据库的驱动包
	 *
	 * 2.装载驱动(ctrl + shift + T)
	 */

	private static final String Driver = "com.mysql.jdbc.Driver";
	// 连接数据库的地址
	private static final String url = "jdbc:mysql://localhost:3306/pets?useUnicode=true&characterEncoding=utf8";
	// 账号
	private static final String user = "root";
	// 密码
	private static final String password = "123456";

	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(Driver);//加载驱动
			conn = DriverManager.getConnection(url, user, password);//获取连接
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭连接
	public static void close(ResultSet rs, PreparedStatement psmt, Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(PreparedStatement psmt, Connection conn) {
		if(psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
