package model;

public class Product {
    private  int peopleId;
    private int id;
    private String name;
    private int SoluongOut;
    private int SoluongIn;
    private int tong;
    private int price;
    private static int nextId = 1;
    private int categoryId;


    public Product( String name,int peopleId,  int categoryId, int soluongOut, int soluongIn,int tong, int price) {
        this.id = nextId++;
        this.peopleId = peopleId;
        this.name = name;
        this.categoryId = categoryId;
        this.SoluongOut = soluongOut;
        this.SoluongIn = soluongIn;
        this.price = price;
        this.tong = soluongIn + soluongOut;
    }
    public Product(String id, String name,int peopleId, int categoryId, int soluongOut, int soluongIn,int tong, int price) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.peopleId = peopleId;
        this.categoryId = categoryId;
        this.SoluongOut = soluongOut;
        this.SoluongIn = soluongIn;
        this.tong = soluongIn + soluongOut;
        this.price = price;
    }

    public Product(int id, String name,int peopleId, int categoryId, int soluongOut, int soluongIn,int tong, int price) {
        this.id = id;
        this.name = name;
        this.peopleId = peopleId;
        this.categoryId = categoryId;
        this.SoluongOut = soluongOut;
        this.SoluongIn = soluongIn;
        this.tong = soluongIn + soluongOut;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSoluongOut() {
        return SoluongOut;
    }

    public void setSoluongOut(int soluongOut) {
        SoluongOut = soluongOut;
    }

    public int getSoluongIn() {
        return SoluongIn;
    }

    public void setSoluongIn(int soluongIn) {
        SoluongIn = soluongIn;
    }

    public int getTong() {
        return tong;
    }

    public void setTong(int tong) {
        this.tong = tong;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Product.nextId = nextId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(int peopleId) {
        this.peopleId = peopleId;
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                "|| Tên sản phẩm ='" + name + '\'' +" || tên người bán "+peopleId+ "|| Loại sản Phẩm =" + categoryId +
                "|| Số Lượng ngoài cửa hàng =" + SoluongOut +
                "|| Số lượng trong kho =" + SoluongIn +
                "|| tổng =" + tong +
                "||giá =" + price + "VNĐ " +
                '}';
    }
}
