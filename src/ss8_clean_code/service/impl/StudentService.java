package ss8_clean_code.service.impl;

import ss8_clean_code.entity.Student;
import ss8_clean_code.repository.StudentRepository;
import ss8_clean_code.service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    private static StudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> getAll() {
        List<Student> students = studentRepository.getAll();

        return students;
    }
}
