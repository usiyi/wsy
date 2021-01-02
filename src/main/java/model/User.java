package model;

public class User {
    private int uid;//用户编号
    private String username;//用户名
    private String password;//用户密码
    private int type;//用户类型

    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    public User(String username, String password, int type) {
        super();
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public User() {

    }

    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }
}
