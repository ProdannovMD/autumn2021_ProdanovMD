package november8.classwork.example;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Andrey");

        student.addMark(3);
        student.addMark(5);
        student.addMark(5);
        student.addMark(4);

        System.out.println(student.prettyPrint());
    }
}
