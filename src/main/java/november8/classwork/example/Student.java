package november8.classwork.example;

import java.util.*;

public class Student {
    private String name;
    private int[] marks = new int[0];

    public Student(String name) {
        this.name = name;
    }

    public void addMark(int mark) {
        int[] newMarks = new int[marks.length + 1];
        System.arraycopy(marks, 0, newMarks, 0, marks.length);
        newMarks[marks.length] = mark;
        marks = newMarks;
    }

    public int[] getMarks() {
        return marks;
    }

    public String prettyPrint() {
        StringJoiner stringJoiner = new StringJoiner(";");
        for (int mark : marks) {
            stringJoiner.add(String.valueOf(mark));
        }
        return name +  " " + stringJoiner;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + Arrays.toString(marks) +
                '}';
    }
}
