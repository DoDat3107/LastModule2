package manager;

import model.User.Staff;
import saveData.ReadAndWriteStaff;

import java.util.ArrayList;
import java.util.List;

public class StaffManager {
    private List<Staff> staffList;
    private ReadAndWriteStaff readAndWriteStaff = new ReadAndWriteStaff();

    public StaffManager() {
        this.staffList = readAndWriteStaff.readData();
    }

    public void dangKy(Staff staff) {
        if (timNhanVienBangUsername(staff.getUsername()) == null) {
            staffList.add(staff);
            readAndWriteStaff.writeData(staffList);
            System.out.println("Đăng ký thành công!");
        } else {
            System.out.println("Tên đăng nhập đã tồn tại!");
        }
    }

    public Staff dangNhap(String username, String password) {
        for (Staff staff : staffList) {
            if (staff.getUsername().equals(username) && staff.getPassword().equals(password)) {
                System.out.println("Đăng nhập thành công!");
                return staff;
            }
        }
        System.out.println("Sai tên đăng nhập hoặc mật khẩu!");
        return null;
    }

    private Staff timNhanVienBangUsername(String username) {
        for (Staff staff : staffList) {
            if (staff.getUsername().equals(username)) {
                return staff;
            }
        }
        return null;
    }
}
