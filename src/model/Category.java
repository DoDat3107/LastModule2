
package model;

public class Category {
    private int id;
    private String name;
    private static int nextId = 1;

    public Category( String name) {
        this.id = nextId++;
        this.name = name;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String id, String name) {
        this.id = Integer.parseInt(id);
        this.name = name;
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

    @Override
    public String toString() {
        return "Id: " + this.id + " Name: " + this.name;
    }
}
