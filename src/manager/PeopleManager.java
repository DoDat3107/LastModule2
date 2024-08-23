package manager;

import model.Category;
import model.People;
import model.Product;
import saveData.ReadAndWritePeople;
import saveData.ReadAndWriteProduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PeopleManager implements IManager<People> {
    private List<People> list;
    private ReadAndWritePeople readAndWritePeople = new ReadAndWritePeople();

    public PeopleManager() {
        this.list = readAndWritePeople.readData();
    }
    @Override
    public void add(People people) {
        this.list.add(people);
        Collections.sort(this.list, Comparator.comparing(People::getName));
        readAndWritePeople.writeData(this.list);
    }

    @Override
    public void update(int id, People people) {
        int index = this.findIndexById(id);
        if (index != -1) {
            this.list.set(index, people);
            readAndWritePeople.writeData(this.list);
        }
    }

    @Override
    public void delete(int id) {
        int index = this.findIndexById(id);
        if (index != -1) {
            this.list.remove(index);
            readAndWritePeople.writeData(this.list);
        }
    }

    @Override
    public List<People> getAll() {
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
    public List<People> FindByName(String name) {
        ArrayList<People> result = new ArrayList<>();
        for (People people : list) {
            if (people.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(people);
            }
        }
        return result;
    }
    public People findById(int id) {
        int index = findIndexById(id);
        if (index != -1) {
            System.out.println("khong tim thay");
            return null;
        }
        return this.list.get(index);
    }
    public List<People> findByCategory(int categoryId) {
        ArrayList<People> result = new ArrayList<>();
        for (People people : list) {
            if (people.getCategoryId() == categoryId) {
                result.add(people);
            }
        }
        return result;
    }

    @Override
    public List<People> FindByPrice(int price) {
        return Collections.emptyList();
    }
}
