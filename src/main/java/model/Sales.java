package model;

public class Sales {
    private int sid;// 销售编号
    private String pname;// 宠物名称
    private String ptype;// 宠物类型
    private int squantity;// 宠物数量
    private String sdate;// 宠物日期

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public int getSquantity() {
        return squantity;
    }

    public void setSquantity(int squantity) {
        this.squantity = squantity;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }
}
