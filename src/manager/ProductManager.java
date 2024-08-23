package manager;

import model.Category;
import model.Product;

import saveData.ReadAndWriteProduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductManager implements IManager<Product>{
    private List<Product> list;
    private ReadAndWriteProduct readAndWriteProduct = new ReadAndWriteProduct();

    public ProductManager() {
        this.list = readAndWriteProduct.readData();
    }
    @Override
    public void add(Product product) {
        this.list.add(product);
        Collections.sort(this.list, Comparator.comparing(Product::getName));
        readAndWriteProduct.writeData(this.list);
    }

    @Override
    public void update(int id, Product product) {
        int index = this.findIndexById(id);
        if (index != -1) {
            this.list.set(index, product);
            readAndWriteProduct.writeData(this.list);
        }
    }

    @Override
    public void delete(int id) {
        int index = this.findIndexById(id);
        if (index != -1) {
            this.list.remove(index);
            readAndWriteProduct.writeData(this.list);
        }
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(this.list);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < this.list.size(); i++) {
            if (id == this.list.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Product> FindByName(String name) {
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : list) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }
    public Product findById(int id) {
        int index = findIndexById(id);
        return this.list.get(index);
    }

    @Override
    public List<Product> FindByPrice(int price) {
        int tolerance = 10000;
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : list) {
            int productPrice = product.getPrice();
            if (Math.abs(productPrice - price) <= tolerance) {
                result.add(product);
            }
        }
        return result;
    }
    public List<Product> findByCategory(int categoryId) {
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : list) {
            if (product.getCategoryId() == categoryId) {
                result.add(product);
            }
        }
        return result;
    }
}
