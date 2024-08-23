package view;

import input.Input;

public class SellerMainMenu {
    SellerMenu sellerMenu=new SellerMenu();
    SellerShopMenu sellerShopMenu=new SellerShopMenu();
    public void selecMenu() {
        int choice;
        do {
            System.out.println("=======Menu=======");
            System.out.println("1. thêm sản phẩm bán");
            System.out.println("2. thêm thông tin người bán ");
            System.out.println("0. Exit");
            System.out.println("Nhập lựa chọn của bạn : ");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:
                    sellerShopMenu.showMainProMenu();
                    break;
                case 2:
                    sellerMenu.showMainPeopleMenu();
                    break;
            }
        } while (choice != 0);
    }
}
