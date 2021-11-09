package november3.homework.domain;

public class Student {
    private static int cnt = 0;

    private int id, age;
    private Faculty faculty;
    private String name;

    public Student(int age, String name, Faculty faculty) {
        this.id = cnt++;
        this.age = age;
        this.faculty = faculty;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", faculty=" + faculty +
                ", name='" + name + '\'' +
                '}';
    }
}
