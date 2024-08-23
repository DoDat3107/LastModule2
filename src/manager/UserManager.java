package manager;


import model.User.User;
import saveData.ReadAndWriteUser;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;
    private ReadAndWriteUser readAndWriteUser = new ReadAndWriteUser();

    public UserManager() {
        this.users = readAndWriteUser.readData();
    }

    public void register(User user) {
        if (findUserByUsername(user.getUsername()) == null) {
            users.add(user);
            readAndWriteUser.writeData(users);
            System.out.println("Đăng ký thành công!");
        } else {
            System.out.println("Tên đăng nhập đã tồn tại!");
        }
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Đăng nhập thành công!");
                return user;
            }
        }
        System.out.println("Tên đăng nhập hoặc mật khẩu không đúng!");
        return null;
    }

    private User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}

