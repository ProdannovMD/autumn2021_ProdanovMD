package november3.classwork.example.services;

import november3.classwork.example.domain.Faculty;
import november3.classwork.example.domain.Student;

import javax.naming.OperationNotSupportedException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecondService implements StudentService{

    public SecondService() {
    }

    private static List<Student> students = Stream.of(
            new Student(18, "Коля", Faculty.CSIT),
            new Student(18, "Сергей", Faculty.CSIT),
            new Student(19, "Дима", Faculty.BIOLOGY),
            new Student(19, "Ваня", Faculty.BIOLOGY),
            new Student(20, "Маша", Faculty.CSIT),
            new Student(20, "Дарья", Faculty.ECONOMIC),
            new Student(21, "Елена", Faculty.ECONOMIC)
    ).collect(Collectors.toList());

    @Override
    public List<Student> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Student addStudent(Student student) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean deleteStudent(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Student getById(int id) {
        throw new UnsupportedOperationException();
    }
}
