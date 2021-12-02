package november26.homework;

import java.util.List;

public class SolarSystemConfig {

    @Bean
    public static SolarSystem getSolarSystem(Star star, List<Planet> planets){
        return new SolarSystem(star, planets);
    }

    @Bean
    @Prototype
    public static Star getStar(){
        return new Star("Sun");
    }

    @Bean("Earth")
    public static Planet getPlanet(){
        return new Planet("Earth");
    }

    @Bean
    public static Planet getPlanet2(){
        return new Planet("Jupiter");
    }
}
