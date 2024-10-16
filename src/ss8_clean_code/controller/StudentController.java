package ss8_clean_code.controller;

import ss8_clean_code.entity.Student;
import ss8_clean_code.service.IStudentService;
import ss8_clean_code.service.impl.StudentService;

public class StudentController {
    private static IStudentService studentService = new StudentService();

    public Student[] getAll() {
        Student[] students = studentService.getAll();
        return students;
    }
}
