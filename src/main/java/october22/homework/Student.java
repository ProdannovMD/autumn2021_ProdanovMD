package october22.homework;

public class Student {
    private String FIO;
    private int studentPassNumber;
    private String courseName;

    public Student(String FIO) {
        this.FIO = FIO;
    }

    public Student(String FIO, int studentPassNumber) {
        this(FIO);
        this.studentPassNumber = studentPassNumber;
    }

    public Student(String FIO, String courseName) {
        this.FIO = FIO;
        this.courseName = courseName;
    }

    public Student(String FIO, int studentPassNumber, String courseName) {
        this(FIO, studentPassNumber);
        this.courseName = courseName;
    }

    public String getFIO() {
        return FIO;
    }

    public int getStudentPassNumber() {
        return studentPassNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setStudentPassNumber(int studentPassNumber) {
        this.studentPassNumber = studentPassNumber;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
