package november3.homework.services;

import november3.homework.annotations.Priority;
import november3.homework.domain.Faculty;
import november3.homework.domain.Student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Priority(1)
public class FirstService implements StudentService {

    public FirstService() {
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
        return students;
    }

    @Override
    public Student addStudent(Student student) {

        if (students.add(student))
            return student;
        return null;
    }

    @Override
    public boolean deleteStudent(int id) {
        return students.remove(id) != null;
    }

    @Override
    public Student getById(int id) {
        return students.get(id);
    }
}
