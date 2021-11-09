package november3.homework;

import november3.homework.factories.Factory;
import november3.homework.services.StudentService;
import november3.homework.services.UniversityService;

import java.io.IOException;
import java.nio.file.Paths;

public class Application {
    public static void main(String[] args) {
        try {
            Factory factory = Factory
                    .getInstance(
                            Paths.get(
                                    ".", "src", "main", "java",
                                    "november3", "homework", "services"
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
