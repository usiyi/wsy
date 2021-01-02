package model;

public class Purchase {
    private int pid;// 进货编号
    private String pname;// 宠物名称
    private String ptype;// 宠物类型
    private int pquantity;// 进货数量
    private String pdate;// 进货日期

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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

    public int getPquantity() {
        return pquantity;
    }

    public void setPquantity(int pquantity) {
        this.pquantity = pquantity;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", ptype='" + ptype + '\'' +
                ", pquantity=" + pquantity +
                ", pdate='" + pdate + '\'' +
                '}';
    }
}
