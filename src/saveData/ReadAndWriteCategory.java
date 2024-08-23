package saveData;

import model.Category;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteCategory {
    private File file = new File("database/category.csv");
    public void writeData(List<Category> list) {
        try {
            String data = "";
            for (Category item: list) {
                data += item.getId() + "," + item.getName() + "\n";
            }
            FileWriter fileWriter = new FileWriter(this.file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public List<Category> readData() {
        List<Category> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(this.file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Category c = new Category(data[0], data[1]);
                list.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}