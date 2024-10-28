package ss8_clean_code.view;

import ss8_clean_code.controller.StudentController;
import ss8_clean_code.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("--------- Quản lý CodeGym ------------");
            System.out.println("1. Quản lý học sinh");
            System.out.println("2. Quản lý giảng viên");
            System.out.println("3. Thoát");
            System.out.println("Mời bạn nhập lựa chọn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    menuStudent();
                    break;
                case 2:
                    System.out.println("Quản lý giảng viên");
                    break;
                case 3:
                    return;
            }
        }

    }

    public static void menuStudent() {
        StudentController studentController = new StudentController();
        while (true) {
            System.out.println("Menu quản lý học sinh");
            System.out.println("1. Hiển thị danh sách học sinh");
            System.out.println("2. Thêm mới học sinh");
            System.out.println("3. Sửa thông tin học sinh");
            System.out.println("4. Xóa học sinh");
            System.out.println("5. Tìm kiếm học sinh theo tên");
            System.out.println("6. Quay lại");
            System.out.print("Nhập lựa chọn: ");
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());
            List<Student> students = new ArrayList<>();
            switch (choice) {
                case 1:
                    students = studentController.getAll();
                    display(students);
                    break;
                case 2:
                    System.out.println("Thêm mới học sinh");
                    break;
                case 3:
                    System.out.println("Sửa thông tin học sinh");
                    break;
                case 4:
                    System.out.println("Xóa học sinh");
                    break;
                case 5:
                    System.out.println("Tìm kiếm học sinh theo tên");
                    String name = scanner.nextLine();
                    students = studentController.searchByName(name);
                    display(students);
                    break;
                case 6:
                    return;
            }
        }

    }

    public static void display(List<Student> students) {
        System.out.println("Hiển thị danh sách học sinh");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
