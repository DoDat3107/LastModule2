package view;

import input.Input;
import manager.UserManager;
import model.User.User;

public class CustomerMenu {
    private UserManager userManager = new UserManager();

    private UserMenu userMenu = new UserMenu();
    private SellerMainMenu sellerMenu2 = new SellerMainMenu();
    public void showMainMenu() {
        int choice;
        do {
            System.out.println("========= Menu Mua bán ============");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("0. Thoát");
            System.out.println("Vui lòng nhập lựa chọn: ");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:
                    showLoginMenu();
                    break;
                case 2:
                    showRegisterMenu();
                    break;
            }
        } while (choice != 0);
    }

    private void showLoginMenu() {
        System.out.println("========= Đăng Nhập ============");
        System.out.println("Tên đăng nhập: ");
        String username = Input.inputString();
        System.out.println("Mật khẩu: ");
        String password = Input.inputString();
        User user = userManager.login(username, password);
        if (user != null) {
            switch (user.getRole()) {
                case "Khách hàng":
                    System.out.println("Xin chào khách hàng: " + user.getUsername());
                    userMenu.showMainProMenu();
                    break;
                case "Người bán":
                    System.out.println("Xin chào người bán: " + user.getUsername());
                    sellerMenu2.selecMenu();
                    break;
            }
        }
    }

    private void showRegisterMenu() {
        System.out.println("========= Đăng Ký ============");
        System.out.println("Tên đăng nhập: ");
        String username = Input.inputString();
        System.out.println("Mật khẩu: ");
        String password = Input.inputString();
        System.out.println("Chọn vai trò (1. Khách hàng, 2. Người bán): ");
        int roleChoice = Input.inputNumber();
        String role = roleChoice == 1 ? "Khách hàng" : "Người bán";
        User newUser = new User(username, password, role);
        userManager.register(newUser);
    }
}

