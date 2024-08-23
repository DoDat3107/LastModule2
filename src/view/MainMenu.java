package view;

import input.Input;

public class MainMenu {
    CustomerMenu customerMenu = new CustomerMenu();
    StaffMenu staffMenu=new StaffMenu();
    public void selecMenu() {
        int choice;
        do {
            System.out.println("=======Menu=======");
            System.out.println("1. Mua bán sản phẩm");
            System.out.println("2. Quản lý cửa hàng ");
            System.out.println("0. Exit");
            System.out.println("Nhập lựa chọn của bạn : ");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:
                    customerMenu.showMainMenu();
                    break;
                case 2:
                    staffMenu.showMainMenu();
                    break;
            }
        } while (choice != 0);
    }
}
