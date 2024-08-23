package manager;

import model.Category;
import model.Product;
import saveData.ReadAndWriteCategory;
import saveData.ReadAndWriteProduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CategoryManager implements IManager<Category> {
    private List<Category> list;
    private ReadAndWriteCategory readAndWriteCategory = new ReadAndWriteCategory();

    public CategoryManager() {
        this.list = readAndWriteCategory.readData();
    }

    @Override
    public void add(Category category) {
        this.list.add(category);
        readAndWriteCategory.writeData(this.list);
    }

    @Override
    public void update(int id, Category category) {
        int index = this.findIndexById(id);
        if (index != -1) {
            this.list.set(index, category);
            readAndWriteCategory.writeData(this.list);
        }
    }

    @Override
    public void delete(int id) {
        int index = this.findIndexById(id);
        if (index != -1) {
            this.list.remove(index);
            readAndWriteCategory.writeData(this.list);
        }
    }

    @Override
    public List<Category> getAll() {
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
    public List<Category> FindByName(String name) {
        ArrayList<Category> result = new ArrayList<>();
        for (Category category : list) {
            if (category.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(category);
            }
        }
        return result;
    }

    @Override
    public List<Category> FindByPrice(int price) {
        return Collections.emptyList();
    }

    public Category findById(int id) {
        int index = findIndexById(id);
        return this.list.get(index);
    }
}
