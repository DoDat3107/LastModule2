package view;

import input.Input;
import manager.StaffManager;
import model.User.Staff;

public class StaffMenu {
    private StaffManager staffManager = new StaffManager();
    MenuQuanLyShop menu = new MenuQuanLyShop();
    public void showMainMenu() {
        int choice;
        do {
            System.out.println("========= Menu Nhân Viên/Quản Lý ============");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("0. Thoát");
            System.out.println("Vui lòng nhập lựa chọn: ");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:
                    hienThiMenuDangNhap();
                    break;
                case 2:
                    hienThiMenuDangKy();
                    break;
            }
        } while (choice != 0);
    }

    private void hienThiMenuDangNhap() {
        System.out.println("========= Đăng nhập ============");
        System.out.println("Tên đăng nhập: ");
        String username = Input.inputString();
        System.out.println("Mật khẩu: ");
        String password = Input.inputString();
        Staff staff = staffManager.dangNhap(username, password);
        if (staff != null) {
            switch (staff.getRole()) {
                case "nhân viên":
                    System.out.println("Chào mừng Nhân Viên: " + staff.getUsername());
                    menu.selecMenu();
                    break;
                case "quản lý":
                    System.out.println("Chào mừng Quản Lý: " + staff.getUsername());
                    menu.selecMenu();
                    break;
            }
        }
    }

    private void hienThiMenuDangKy() {
        System.out.println("========= Đăng ký ============");
        System.out.println("Tên đăng nhập: ");
        String username = Input.inputString();
        System.out.println("Mật khẩu: ");
        String password = Input.inputString();
        System.out.println("Chọn vai trò:");
        System.out.println("1. Nhân viên");
        System.out.println("2. Quản lý");
        int roleChoice = Input.inputNumber();
        String role = null;
        switch (roleChoice) {
            case 1:
                role = "nhân viên";
                break;
            case 2:
                role = "quản lý";
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                return;
        }
        Staff newStaff = new Staff(username, password, role);
        staffManager.dangKy(newStaff);
    }
}
