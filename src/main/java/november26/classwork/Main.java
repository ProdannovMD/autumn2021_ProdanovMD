package november26.classwork;

import november26.classwork.ApplicationContext;
import november26.classwork.Planet;
import november26.classwork.SolarSystem;
import november26.classwork.Star;
import november26.classwork.configs.SolarSystemConfiguration;
import november26.classwork.configs.SolarSystemConfiguration2;

public class Main {
    public static void main(String[] args) {
        ApplicationContext.init(SolarSystemConfiguration.class);
        ApplicationContext.init(SolarSystemConfiguration2.class);

        SolarSystem solarSystem = new SolarSystem(
                ApplicationContext.getBean(Star.class),
                ApplicationContext.getBeans(Planet.class)
        );
        System.out.println(solarSystem);
    }
}
