package saveData;

import model.User.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteUser {
    private File file = new File("database/users.csv");

    public void writeData(List<User> list) {
        try {
            StringBuilder data = new StringBuilder();
            for (User user : list) {
                data.append(user.getId()).append(",")
                        .append(user.getUsername()).append(",")
                        .append(user.getPassword()).append(",")
                        .append(user.getRole()).append("\n");
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(data.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<User> readData() {
        List<User> users = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                User user = new User(data[1], data[2], data[3]);
                users.add(user);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }
}
