package november26.homework;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ApplicationContext();
        applicationContext.init(Paths.get("src/main/java/november26/homework/"));

        SolarSystem solarSystem = applicationContext.getBean(SolarSystem.class);
        System.out.println(solarSystem);

        System.out.println(applicationContext.getBean("getStar",Star.class));
        System.out.println(applicationContext.getBean("getStar",Star.class));
        System.out.println(applicationContext.getBean("getStar",Star.class));
        System.out.println(applicationContext.getBean("getStar",Star.class));

        System.out.println(applicationContext.getBeans(Planet.class));

        applicationContext.init(new Comet("My comet"));
        System.out.println(applicationContext.getBean(Comet.class));
    }
}
