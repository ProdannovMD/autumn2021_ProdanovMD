package november26.homework;

@Bean
public class Comet {
    String name;

    public Comet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Comet{" +
                "name='" + name + '\'' +
                '}';
    }
}
