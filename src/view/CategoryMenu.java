package view;

import input.Input;
import manager.CategoryManager;
import model.Category;

import java.util.List;

public class CategoryMenu {
    private CategoryManager categoryManager = new CategoryManager();

    public void showMainCateMenu() {
        int choice;
        do {
            System.out.println("========= Menu chính ============");
            System.out.println("2.1. Thêm mới loại mặt hàng");
            System.out.println("2.2. Sửa Loại mặt hàng");
            System.out.println("2.3. Xóa Loại mặt hàng");
            System.out.println("2.4. Tìm kiếm theo id loại mặt hàng");
            System.out.println("2.5. Tìm kiếm theo tên Loại");
            System.out.println("2.6. Hiển thị tất cả ");
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
                    showSearchByIdMenu();
                    break;
                case 5:
                    showSearchByNameMenu();
                    break;
                case 6:
                    showAllMenu();
                    break;
            }
        } while (choice != 0);
    }

    public void showAddMenu() {
        System.out.println("========== Thêm loại sản phẩm ========== ");
        System.out.println("Nhập tên: ");
        String name = Input.inputString();
        Category category = new Category(name);
        categoryManager.add(category);
        System.out.println("Thêm thành công");
    }

    public void showEditMenu() {
        System.out.println("========== Sửa Loại Mặt Hàng ========== ");
        System.out.println("Nhập ID của loại mặt hàng muốn sửa: ");
        int idEdit = Input.inputNumber();
        Category existingCategory = categoryManager.getAll().stream()
                .filter(c -> c.getId() == idEdit)
                .findFirst()
                .orElse(null);
        if (existingCategory == null) {
            System.out.println("Không tìm thấy loại mặt hàng có ID = " + idEdit);
        } else {
            System.out.println("Nhập tên mới: ");
            String name = Input.inputString();
            Category category = new Category(idEdit, name);
            categoryManager.update(idEdit, category);
            System.out.println("Sửa thông tin loại mặt hàng thành công!");
        }
    }

    public void showMenuRemove() {
        System.out.println("=========== Menu Xóa Loại Mặt Hàng ============");
        System.out.println("Nhập Id Loại Mặt Hàng muốn xoá: ");
        int idRemove = Input.inputNumber();
        categoryManager.delete(idRemove);
        System.out.println("Xoá thành công");
    }

    public void showAllMenu() {
        List<Category> categoryList = categoryManager.getAll();
        if (categoryList.isEmpty()) {
            System.out.println("Danh sách loại mặt hàng trống.");
        } else {
            for (Category c : categoryList) {
                System.out.println(c);
            }
        }
    }

    private void showSearchByIdMenu() {
        System.out.print("Nhập ID loại mặt hàng cần tìm: ");
        int id = Input.inputNumber();
        Category category = categoryManager.getAll().stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
        if (category == null) {
            System.out.println("Loại mặt hàng không tồn tại.");
        } else {
            System.out.println(category);
        }
    }

    private void showSearchByNameMenu() {
        System.out.print("Nhập tên loại mặt hàng cần tìm: ");
        String name = Input.inputString();
        List<Category> categories = categoryManager.FindByName(name);
        if (categories.isEmpty()) {
            System.out.println("Loại mặt hàng cần tìm không tồn tại.");
        } else {
            for (Category category : categories) {
                System.out.println(category);
            }
        }
    }
}