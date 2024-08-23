package saveData;

import model.Category;
import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteProduct {
    private File file = new File("database/product.csv");
    public void writeData(List<Product> list) {
        try {
            String data = "";
            for (Product item: list) {
                data += item.getId() + "," + item.getName() +","+item.getPeopleId()+","+item.getCategoryId()+","+item.getSoluongOut()+","+item.getSoluongIn()+","+item.getTong()+","+item.getPrice()+ "\n";
            }
            FileWriter fileWriter = new FileWriter(this.file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public List<Product> readData() {
        List<Product> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(this.file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Product c = new Product(data[0],data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3]),Integer.parseInt(data[4]),Integer.parseInt(data[5]),Integer.parseInt(data[6]),Integer.parseInt(data[7]));
                list.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
