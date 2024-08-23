package view;

import input.Input;
import manager.CategoryManager;
import manager.PeopleManager;
import manager.ProductManager;
import model.Category;
import model.People;
import model.Product;

import java.util.List;

public class UserMenu {
    private ProductManager productManager = new ProductManager();
    private CategoryManager categoryManager = new CategoryManager();


    public void showMainProMenu() {
        int choice;
        do {
            System.out.println("========= Menu chính ============");
            System.out.println("1.1. Tìm kiếm theo id  mặt hàng");
            System.out.println("1.2. Tìm kiếm theo tên mặt hàng");
            System.out.println("1.3. Tìm kiếm theo loại mặt hàng");
            System.out.println("1.4. Tìm kiếm theo giá gần đúng của mặt hàng");
            System.out.println("1.5. Hiển thị tất cả ");
            System.out.println("0. Thoát");
            System.out.println("Vui lòng nhập lựa chon: ");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:
                    showSearchByIdMenu();
                    break;
                case 2:
                    showSearchByNameMenu();
                    break;
                case 3:
                    showSearchByCategoryMenu();
                    break;
                case 4:
                    showFindByPrice();
                    break;
                case 5:
                    showAllMenu();
                    break;
            }
        } while (choice != 0);
    }

    private void showSearchByIdMenu() {
        System.out.print("Nhập tên mặt hàng cần tìm: ");
        int id = Input.inputNumber();
        Product product = productManager.findById(id);
        if (product == null) {
            System.out.println("Mặt hàng cần không tồn tại.");
        } else {
            System.out.println(product);
        }
    }
    private void showSearchByNameMenu() {
        System.out.print("Nhập tên mặt hàng cần tìm: ");
        String name = Input.inputString();
        List<Product> categories = productManager.FindByName(name);
        if (categories.isEmpty()) {
            System.out.println("Tên mặt  cần tìm không tồn tại.");
        } else {
            for (Product product : categories) {
                System.out.println(product);
            }
        }
    }
    public void showAllMenu() {
        List<Product> productList = productManager.getAll();
        if (productList.isEmpty()) {
            System.out.println("Danh sách mặt hàng trống.");
        } else {
            for (Product c : productList) {
                System.out.println(c);
            }
        }
    }
    public void showFindByPrice() {
        System.out.println("=======Tìm kiếm theo Giá gần đúng=======");
        System.out.println("Nhập Giá sản phẩm cần tìm kiếm : ");
        int price = Input.inputNumber();
        List<Product> foundProducts = productManager.FindByPrice(price);
        if (foundProducts.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm có giá gần đúng " + price);
        } else {
            System.out.println("Các sản phẩm có giá gần đúng " + price + ":");
            for (Product product : foundProducts) {
                System.out.println("ID: " + product.getId() + ", Tên: " + product.getName() + ", Số lượng: "+product.getTong()+ ", Giá: " + product.getPrice());
            }
        }

    }
    public void showSearchByCategoryMenu() {
        System.out.println("========== Tìm kiếm theo loại mặt hàng ========== ");
        List<Category> CategoryList = categoryManager.getAll();
        for (int i = 0; i < CategoryList.size(); i++) {
            System.out.println(i + 1 + ". " + CategoryList.get(i).getName());
        }
        System.out.println("Vui lòng chọn loại mặt hàng: ");
        int choiceIndexCate = Input.inputNumber();
        if (choiceIndexCate < 1 || choiceIndexCate > CategoryList.size()) {
            System.out.println("Lựa chọn không hợp lệ.");
            return;
        }
        int categoryId = CategoryList.get(choiceIndexCate - 1).getId();
        List<Product> foundProducts = productManager.findByCategory(categoryId);
        if (foundProducts.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm trong loại mặt hàng này.");
        } else {
            System.out.println("Các sản phẩm trong loại mặt hàng này:");
            for (Product product : foundProducts) {
                System.out.println(product);
            }
        }
    }

}
