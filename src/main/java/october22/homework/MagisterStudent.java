package october22.homework;

public class MagisterStudent extends Student{
    private String bachelorCourseName;

    public MagisterStudent(String FIO) {
        super(FIO);
    }

    public MagisterStudent(String FIO, int studentPassNumber) {
        super(FIO, studentPassNumber);
    }

    public MagisterStudent(String FIO, String courseName) {
        super(FIO, courseName);
    }

    public MagisterStudent(String FIO, int studentPassNumber, String courseName) {
        super(FIO, studentPassNumber, courseName);
    }

    public MagisterStudent(String FIO, int studentPassNumber, String courseName, String bachelorCourseName) {
        super(FIO, studentPassNumber, courseName);
        this.bachelorCourseName = bachelorCourseName;
    }

    public String getBachelorCourseName() {
        return bachelorCourseName;
    }

    public void setBachelorCourseName(String bachelorCourseName) {
        this.bachelorCourseName = bachelorCourseName;
    }
}
