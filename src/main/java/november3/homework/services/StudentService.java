package november3.homework.services;

import november3.homework.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student addStudent(Student student);
    boolean deleteStudent(int id);
    Student getById(int id);
}
