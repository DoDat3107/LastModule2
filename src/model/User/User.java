package model.User;

public class User {
    private int id;
    private String username;
    private String password;
    private String role; //
    private static int nextId = 1;

    public User(String username, String password, String role) {
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
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
