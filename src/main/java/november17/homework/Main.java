package november17.homework;

import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/main/resources/november17/inputTest.txt");
        PatternReader reader = new PatternReader(new FileReader(inputFile), Pattern.compile("\\d"));
        char[] buff = new char[7];
        int read = reader.read(buff, 0, buff.length);
        for (int i = 0; i < read; i++) {
            System.out.print(buff[i]);
        }
        System.out.println();

        File outputFile = new File("src/main/resources/november17/outputTest.txt");
        PatternWriter writer = new PatternWriter(new FileWriter(outputFile), Pattern.compile("\\S"));
        String output = "Должно записаться без пробелов!";
        writer.write(output, 0, output.length());
        writer.flush();

        reader.close();
        writer.close();
    }
}
