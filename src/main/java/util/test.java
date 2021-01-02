package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException {
        //3.需要执行的sql语句（?是占位符，代表一个参数）
        String sql = "insert into user(uid,username,password,type) values(?,?,?,?)";
        //4.获取预处理对象，并依次给参数赋值
        Connection conn=DbUtil.getConn();
        PreparedStatement statement = conn.prepareCall(sql);
        statement.setInt(1,12); //数据库字段类型是int，就是setInt；1代表第一个参数
        statement.setString(2,"小明");
        statement.setString(3,"123456");
        statement.setInt(4,0);
        //5.执行sql语句（执行了几条记录，就返回几）
        int i = statement.executeUpdate();
        System.out.println(i);
    }
}
