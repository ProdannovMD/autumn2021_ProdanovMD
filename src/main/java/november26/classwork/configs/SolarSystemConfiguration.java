package november26.classwork.configs;

import november26.classwork.Planet;
import november26.classwork.Star;
import november26.classwork.annotations.Bean;

public class SolarSystemConfiguration {
    @Bean
    public static Star getStar() {
        return new Star("Red star");
    }

    @Bean
    public static Planet getPlanet1() {
        return new Planet("Galileo");
    }

    @Bean
    public static Planet getPlanet2() {
        return new Planet("Xena");
    }

    @Bean
    public static Planet getPlanet3() {
        return new Planet("Titan");
    }
}
