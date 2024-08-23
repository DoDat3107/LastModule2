package view;

import input.Input;
import manager.CategoryManager;
import manager.PeopleManager;
import model.Category;
import model.People;

import java.util.List;

public class SellerMenu {
    private PeopleManager peopleManager = new PeopleManager();
    private CategoryManager categoryManager = new CategoryManager();

    public void showMainPeopleMenu() {
        int choice;
        do {
            System.out.println("========= Menu chính ============");
            System.out.println("3.1. Đăng ký bán hàng");
            System.out.println("3.2. Sửa  thông tin đăng ký bán hàng");
            System.out.println("3.3. Xóa  thông tin đăng ký bán hàng");
            System.out.println("3.4. Hiển thị tất cả ");
            System.out.println("0. Thoát");
            System.out.println("Vui lòng nhập lựa chon: ");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:
                    showAddMenu();
                    break;
                case 2:
                    showEditMenu();
                    break;
                case 3:
                    showMenuRemove();
                    break;
                case 4:
                    showAllMenu();
                    break;
            }
        } while (choice != 0);
    }

    public void showAddMenu() {
        System.out.println("========== Thêm sản phẩm ========== ");
        System.out.println("Nhập tên người đăng ký bán hàng: ");
        String name = Input.inputString();
        System.out.println("Nhập tuổi");
        int age = Input.inputNumber();
        List<Category> CategoryList = categoryManager.getAll();
        for (int i = 0; i < CategoryList.size(); i++) {
            System.out.println(i + 1 + ". " + CategoryList.get(i).getName());
        }
        System.out.println("Vui lòng chọn loại mặt hàng: ");
        int choiceIndexCate = Input.inputNumber();
        int catelogyId = CategoryList.get(choiceIndexCate - 1).getId();
        People people = new People(name, age, catelogyId);
        peopleManager.add(people);
        System.out.println("Thêm thành công");
    }

    public void showEditMenu() {
        System.out.println("========== Sửa sản phẩm ========== ");
        System.out.println("Nhập ID của thông tin đăng ký sửa: ");
        int idEdit = Input.inputNumber();
        System.out.println("Nhập tên muốn sửa: ");
        String name = Input.inputString();
        System.out.println("Nhập tuổi muốn sửa");
        int age = Input.inputNumber();
        List<Category> CategoryList = categoryManager.getAll();
        for (int i = 0; i < CategoryList.size(); i++) {
            System.out.println(i + 1 + ". " + CategoryList.get(i).getName());
        }
        System.out.println("Vui lòng chọn loại mặt hàng: ");
        int choiceIndexCate = Input.inputNumber();
        int catelogyId = CategoryList.get(choiceIndexCate - 1).getId();
        People people = new People(idEdit, name, age, catelogyId);
        peopleManager.update(idEdit, people);
        System.out.println("Thêm thành công");
    }

    public void showMenuRemove() {
        System.out.println("========== Xóa Sinh Viên ========== ");
        System.out.println("Nhập ID người bán cần xóa: ");
        int idRemove = Input.inputNumber();
        peopleManager.delete(idRemove);
        System.out.println("Xóa thành công.");
    }
    public void showAllMenu() {
        List<People> peopleList = peopleManager.getAll();
        if (peopleList.isEmpty()) {
            System.out.println("Danh sách người bán hàng trống.");
        } else {
            for (People c : peopleList) {
                System.out.println(c);
            }
        }
    }

}