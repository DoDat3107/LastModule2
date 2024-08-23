package view;

import input.Input;
import manager.CategoryManager;
import manager.PeopleManager;
import manager.ProductManager;
import model.Category;
import model.People;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMenu {
    private ProductManager productManager = new ProductManager();
    private CategoryManager categoryManager = new CategoryManager();
    private PeopleManager peopleManager = new PeopleManager();

    public void showMainProMenu() {
        int choice;
        do {
            System.out.println("========= Menu chính ============");
            System.out.println("1.1. Thêm mới mặt hàng");
            System.out.println("1.2. Sửa  mặt hàng");
            System.out.println("1.3. Xóa  mặt hàng");
            System.out.println("1.4. Tìm kiếm theo id  mặt hàng");
            System.out.println("1.5. Tìm kiếm theo tên mặt hàng");
            System.out.println("1.6. Tìm kiếm theo loại mặt hàng");
            System.out.println("1.7. Tìm kiếm theo giá gần đúng của mặt hàng");
            System.out.println("1.8. Hiển thị tất cả ");
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
                    showSearchByCategoryMenu();
                    break;
                case 7:
                    showFindByPrice();
                    break;
                case 8:
                    showAllMenu();
                    break;
            }
        } while (choice != 0);
    }

    public void showAddMenu() {
        System.out.println("========== Thêm sản phẩm ========== ");
        List<People> peopleList = peopleManager.getAll();
        for (int i = 0; i < peopleList.size(); i++) {
            System.out.println(i + 1 + ". " + peopleList.get(i).getName());
        }
        System.out.println("Vui lòng chọn tên người bán: ");
        int choiceIndexPeople = Input.inputNumber();
        int peoplelogyId = peopleList.get(choiceIndexPeople - 1).getId();
        System.out.println("Nhập tên SP: ");
        String name = Input.inputString();
        System.out.println("Nhập Số lượng đang bán ngoài cửa hàng");
        int SoLuongOut = Input.inputNumber();
        System.out.println("Nhập số lương đang tồn trong kho");
        int SoLuongIn = Input.inputNumber();
        int tong =SoLuongIn+SoLuongOut;
        System.out.println("Nhập giá sản phẩm");
        int price= Input.inputNumber();
        List<Category> CategoryList = categoryManager.getAll();
        for (int i = 0; i < CategoryList.size(); i++) {
            System.out.println(i + 1 + ". " + CategoryList.get(i).getName());
        }
        System.out.println("Vui lòng chọn loại mặt hàng: ");
        int choiceIndexCate = Input.inputNumber();
        int catelogyId = CategoryList.get(choiceIndexCate - 1).getId();
        Product product = new Product(name,peoplelogyId,catelogyId,SoLuongOut,SoLuongIn,tong,price);
        productManager.add(product);
        System.out.println("Thêm thành công");
    }
    public void showEditMenu(){
        System.out.println("========== Sửa sản phẩm ========== ");
        System.out.println("Nhập ID của sản phẩm muốn sửa: ");
        int idEdit = Input.inputNumber();
        List<People> peopleList = peopleManager.getAll();
        for (int i = 0; i < peopleList.size(); i++) {
            System.out.println(i + 1 + ". " + peopleList.get(i).getName());
        }
        System.out.println("Vui lòng chọn tên người bán: ");
        int choiceIndexPeople = Input.inputNumber();
        int peoplelogyId = peopleList.get(choiceIndexPeople - 1).getId();
        System.out.println("Nhập tên: ");
        String name = Input.inputString();
        System.out.println("Nhập Số lượng đang bán ngoài cửa hàng");
        int SoLuongOut = Input.inputNumber();
        System.out.println("Nhập số lương đang tồn trong kho");
        int SoLuongIn = Input.inputNumber();
        int tong =SoLuongIn+SoLuongOut;
        System.out.println("Nhập giá sản phẩm");
        int price= Input.inputNumber();
        List<Category> CategoryList = categoryManager.getAll();
        for (int i = 0; i < CategoryList.size(); i++) {
            System.out.println(i + 1 + ". " + CategoryList.get(i).getName());
        }
        System.out.println("Vui lòng chọn loại mặt hàng: ");
        int choiceIndexCate = Input.inputNumber();
        int catelogyId = CategoryList.get(choiceIndexCate - 1).getId();
        Product product = new Product(idEdit,name,peoplelogyId,catelogyId,SoLuongOut,SoLuongIn,tong,price);
        productManager.update(idEdit,product);
        System.out.println("Thêm thành công");
    }
    public void showMenuRemove() {
        System.out.println("========== Xóa Sinh Viên ========== ");
        System.out.println("Nhập ID sinh viên cần xóa: ");
        int idRemove = Input.inputNumber();
        productManager.delete(idRemove);
        System.out.println("Xóa sinh viên thành công.");
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
