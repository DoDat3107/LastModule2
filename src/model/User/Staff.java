package model.User;

public class Staff {
    private int id;
    private String username;
    private String password;
    private String role; // "nhân viên", "quản lý"
    private static int nextId = 1;

    public Staff(String username, String password, String role) {
        this.id = nextId++;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Nhân viên{" +
                "id=" + id +
                ", tên đăng nhập='" + username + '\'' +
                ", vai trò='" + role + '\'' +
                '}';
    }
}
