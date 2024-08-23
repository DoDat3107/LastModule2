package saveData;

import model.Category;
import model.People;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWritePeople {
    private File file = new File("database/people.csv");
    public void writeData(List<People> list) {
        try {
            String data = "";
            for (People item: list) {
                data += item.getId() + "," + item.getName() +","+item.getAge()+","+item.getCategoryId()+ "\n";
            }
            FileWriter fileWriter = new FileWriter(this.file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public List<People> readData() {
        List<People> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(this.file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                People c = new People(data[0], data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3]));
                list.add(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
