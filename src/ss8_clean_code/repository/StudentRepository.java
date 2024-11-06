package ss8_clean_code.repository;

import ss8_clean_code.entity.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    public static final String SRC_STUDENT = "src/ss8_clean_code/data/student.dat";


    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        File file = new File(SRC_STUDENT);
//        try {
//            FileReader fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line;
//            Student student;
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] temp = line.split(",");
//                student = new Student(Integer.parseInt(temp[0]), temp[1], temp[2], Double.parseDouble(temp[3]), temp[4]);
//                students.add(student);
//            }
//            bufferedReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("Không tìm thấy file");
//        } catch (IOException e) {
//            System.out.println("Lỗi đọc file");
//        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            students = (List<Student>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Loi ko tim thay file");
        } catch (IOException e) {
            System.out.println("Loi doc file");
        } catch (ClassNotFoundException e) {
            System.out.println("Loi khong tim thay class");
        }
        return students;
    }

    public void save(Student s) {
        List<Student> students = getAll();
        students.add(s);
        writeFileBinary(students);
    }

    public void writeFileBinary(List<Student> students) {
        File file = new File(SRC_STUDENT);
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(students);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Looix khong tim thay file");
        } catch (IOException e) {
            System.out.println("loi ghi file");
        }
    }

//    private void writeFile(List<Student> students, boolean append) {
//        File file = new File(SRC_STUDENT);
//
//        FileWriter fileWriter = null;
//        BufferedWriter bufferedWriter = null;
//        try {
//            fileWriter = new FileWriter(file, append);
//            bufferedWriter = new BufferedWriter(fileWriter);
//            for (Student temp : students) {
//                bufferedWriter.write(toString(temp));
//                bufferedWriter.newLine();
//            }
//
//        } catch (IOException e) {
//            System.out.println("Lỗi ghi file");
//        } finally {
//            if (bufferedWriter != null) {
//                try {
//                    bufferedWriter.close();
//                } catch (IOException e) {
//                    System.out.println("Lỗi đóng file");
//                }
//            }
//        }
//    }

//    private String toString(Student s) {
//        return s.getCode() + "," + s.getName() + "," + s.getAddress() + "," + s.getPoint() + "," + s.getClassName();
//    }

    public void deleteById(int id) {
        List<Student> students = getAll();
        for (Student student : students) {
            if (student.getCode() == id) {
                students.remove(student);
                break;
            }
        }
        writeFileBinary(students);

    }
}
