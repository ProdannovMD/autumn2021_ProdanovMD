package november3.classwork.example;

import november3.classwork.example.domain.Faculty;
import november3.classwork.example.domain.Student;
import november3.classwork.example.factories.Factory;
import november3.classwork.example.services.StudentService;
import november3.classwork.example.services.UniversityService;

import java.io.IOException;
import java.nio.file.Paths;

public class Application {
    public static void main(String[] args) {
        try {
            Factory factory = Factory
                    .getInstance(
                            Paths.get(
                                    ".", "src", "main", "java",
                                    "november3", "classwork", "example", "services"
                            )
                    );

            UniversityService universityService = ((UniversityService) Factory.getObjects().get("UniversityService"));
            StudentService studentService = universityService.getStudentService();
            studentService.getAll().forEach(System.out::println);
        } catch (IOException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
