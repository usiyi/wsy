package model;

public class Pets {
    private int petid;//宠物编号
    private String petname;//宠物名称
    private String pettype;//宠物类别
    private float purPrice;//宠物进价
    private float selPrice;//宠物售价
    private int quantity;//宠物数量

    public int getPetid() {
        return petid;
    }

    public void setPetid(int petid) {
        this.petid = petid;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getPettype() {
        return pettype;
    }

    public void setPettype(String pettype) {
        this.pettype = pettype;
    }

    public float getPurPrice() {
        return purPrice;
    }

    public void setPurPrice(float purPrice) {
        this.purPrice = purPrice;
    }

    public float getSelPrice() {
        return selPrice;
    }

    public void setSelPrice(float selPrice) {
        this.selPrice = selPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Pets{" +
                "petid=" + petid +
                ", petname='" + petname + '\'' +
                ", pettype='" + pettype + '\'' +
                ", purPrice=" + purPrice +
                ", selPrice=" + selPrice +
                ", quantity=" + quantity +
                '}';
    }
}
