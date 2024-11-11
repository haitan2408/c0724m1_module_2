package ss8_clean_code.view;

import ss8_clean_code.controller.StudentController;
import ss8_clean_code.entity.Student;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
            int choice = inputChoice();
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
        int choice;
        List<Student> students;
        Student student;
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
            choice = inputChoice();
            switch (choice) {
                case 1:
                    students = studentController.getAll();
                    display(students);
                    break;
                case 2:
                    student = inputStudent();
                    studentController.save(student);
                    System.out.println("Thêm mới thành công");
                    break;
                case 3:
                    System.out.println("Sửa thông tin học sinh");
                    break;
                case 4:
                    System.out.print("Nhập id cần xóa: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    boolean isFind = studentController.isExistsStudent(id);
                    if(!isFind) {
                        System.out.println("Không tìm thấy student có id là "+ id);
                    } else {
                        System.out.println("Bạn có chắc muốn xóa hay không. Nhấn Y nếu đồng ý hoặc bất kỳ kí tự khác nếu không?");
                        String isConfirm = scanner.nextLine();
                        if(isConfirm.equalsIgnoreCase("y")) {
                                studentController.deleteById(id);
                            System.out.println("Xóa học sinh thành công");
                        }
                    }
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

    private static Student inputStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mời bạn nhập code: ");
        int code = Integer.parseInt(scanner.nextLine());
        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();

        while (!name.matches("^[A-Z][a-z ]{5,100}$")) {
            System.out.println("Bạn nhập sai định dạng tên");
            System.out.print("Mời bạn nhập lại: ");
            name = scanner.nextLine();
        }
        System.out.print("Mời bạn nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Mời bạn nhập điểm: ");
        double point = Double.parseDouble(scanner.nextLine());
//        Định dạng chuỗi CXXXX(M|L)X-JV103
        System.out.print("Mời bạn nhập lớp: ");
        String className = scanner.nextLine();
        return new Student(code, name, address, point, className);
    }

    public static void display(List<Student> students) {
        System.out.println("Hiển thị danh sách học sinh");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static int inputChoice() {
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            return choice;
        } catch (NumberFormatException e) {
            System.out.println("Nhập sai lựa chọn. Mời bạn nhập lại");
        } catch (Exception e) {
            System.out.println("Lỗi khác");
        }
        return 0;
    }
}
