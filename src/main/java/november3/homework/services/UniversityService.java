package november3.homework.services;

import november3.homework.annotations.Inject;
import november3.homework.domain.Student;

import java.util.List;

public class UniversityService {
    @Inject
    private StudentService studentService;

    public UniversityService() { }

    public StudentService getStudentService() {
        return studentService;
    }

    public List<Student> getAllStudents() {
        return studentService.getAll();
    }
}
