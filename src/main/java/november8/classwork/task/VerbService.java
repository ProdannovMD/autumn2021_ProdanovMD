package november8.classwork.task;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VerbService {
    private static final VerbService instance = new VerbService();
    private final String PATH = "src/main/resources/october8/verbs.csv";
    private final String SEPARATOR = ";";
    private final List<Verb> verbs;

    private VerbService() {
        verbs = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(PATH))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(SEPARATOR);
                verbs.add(new Verb(split[0].trim(), split[1].trim(), split[2].trim(), split[3].trim()));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static VerbService getInstance() {
        return instance;
    }

    public List<Verb> getVerbs() {
        return verbs;
    }
}
