package october20.homework;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vector[] vectors = Vector.getRandomVectors(2);
        System.out.println(Arrays.toString(vectors));

        System.out.println("Длины:");
        System.out.println(vectors[0].length());
        System.out.println(vectors[1].length());
        System.out.println("Сумма и разность:");
        System.out.println(vectors[0].add(vectors[1]));
        System.out.println(vectors[0].subtract(vectors[1]));
        System.out.println("Скалярное и векторное произведения:");
        System.out.println(vectors[0].scalarMult(vectors[1]));
        System.out.println(vectors[0].vectorMult(vectors[1]));
        System.out.println("Косинус угла:");
        System.out.println(vectors[0].angleCos(vectors[1]));
    }
}
