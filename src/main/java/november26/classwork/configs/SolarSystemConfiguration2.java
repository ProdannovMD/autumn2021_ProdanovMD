package november26.classwork.configs;

import november26.classwork.Planet;
import november26.classwork.annotations.Bean;

public class SolarSystemConfiguration2 {
    @Bean
    public static Planet getPlanet1() {
        return new Planet("Nibiru");
    }

    @Bean
    public static Planet getPlanet2() {
        return new Planet("Cerberus");
    }
}
