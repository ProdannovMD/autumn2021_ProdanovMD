package november26.homework;

import java.util.Random;

public class Star {
    private String name;

    public Star(String name) {
        this.name = name + new Random().nextInt(20);
    }

    @Override
    public String toString() {
        return "Star{" +
                "name='" + name + '\'' +
                '}';
    }
}
