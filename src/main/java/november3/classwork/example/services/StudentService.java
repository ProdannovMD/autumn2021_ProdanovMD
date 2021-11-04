package november3.classwork.example.services;

import november3.classwork.example.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student addStudent(Student student);
    boolean deleteStudent(int id);
    Student getById(int id);
}
