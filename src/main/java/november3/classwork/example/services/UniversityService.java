package november3.classwork.example.services;

import november3.classwork.example.annotations.Inject;
import november3.classwork.example.domain.Student;

import java.util.List;

public class UniversityService {
    @Inject(className = "FirstService")
    private StudentService studentService;

    public UniversityService() { }

    public StudentService getStudentService() {
        return studentService;
    }

    public List<Student> getAllStudents() {
        return studentService.getAll();
    }
}
