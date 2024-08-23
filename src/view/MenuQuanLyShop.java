package view;

import input.Input;

import java.util.Scanner;

public class MenuQuanLyShop {
    private ProductMenu productMenu = new ProductMenu();
    private PeopleMenu peopleMenu = new PeopleMenu();
    private CategoryMenu categoryMenu = new CategoryMenu();



    public void selecMenu() {
        int choice;
        do {
            System.out.println("=======Menu=======");
            System.out.println("1. Quản lý Sản phẩm");
            System.out.println("2. Quản lý loại mặt hàng ");
            System.out.println("3. Quản lý người bán ");
            System.out.println("0. Exit");
            System.out.println("Nhập lựa chọn của bạn : ");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:
                    productMenu.showMainProMenu();
                    break;
                case 2:
                    categoryMenu.showMainCateMenu();
                    break;
                case 3:
                    peopleMenu.showMainPeopleMenu();
                    break;
            }
        } while (choice != 0);
    }

}
