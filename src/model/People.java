package model;

public class People {
    private int id;
    private String name;
    private int age;
    private static int nextId=1;
    private int categoryId;

    public People(String name,int age,int categoryId) {
        this.id = nextId++;
        this.name = name;
        this.age = age;
        this.categoryId = categoryId;
    }
    public People(String id, String name,int age, int categoryId) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.age = age;
        this.categoryId = categoryId;
    }

    public People(int id, String name,int age, int categoryId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.categoryId = categoryId;
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


    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        People.nextId = nextId;
    }

    public int getAge() {
        return age;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                "|| tên ='" + name + '\'' +
                "|| tuổi=" + age +
                "|| quản lý gian hàng ='" +categoryId + '\'' +
                '}';
    }
}
