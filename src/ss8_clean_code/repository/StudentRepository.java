package ss8_clean_code.repository;

import ss8_clean_code.entity.Student;

public class StudentRepository {
    private static Student[] students = new Student[5];

    static {
        students[0] = new Student(1, "Nguyễn Văn A", "Hà Nội", 10, "C0724G1");
        students[1] = new Student(1, "Nguyễn Văn A", "Hà Nội", 10, "C0724G1");
        students[2] = new Student(1, "Nguyễn Văn A", "Hà Nội", 10, "C0724G1");
        students[3] = new Student(1, "Nguyễn Văn A", "Hà Nội", 10, "C0724G1");
        students[4] = new Student(1, "Nguyễn Văn A", "Hà Nội", 10, "C0724G1");
    }

    public Student[] getAll() {
        return students;
    }
}
