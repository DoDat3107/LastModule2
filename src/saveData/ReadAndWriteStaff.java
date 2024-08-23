package saveData;

import model.User.Staff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteStaff {
    private File file = new File("database/nhanvien_quanly.csv");

    public void writeData(List<Staff> list) {
        try {
            StringBuilder data = new StringBuilder();
            for (Staff staff : list) {
                data.append(staff.getId()).append(",")
                        .append(staff.getUsername()).append(",")
                        .append(staff.getPassword()).append(",")
                        .append(staff.getRole()).append("\n");
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(data.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Staff> readData() {
        List<Staff> staffList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Staff staff = new Staff(data[1], data[2], data[3]);
                staffList.add(staff);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return staffList;
    }
}
