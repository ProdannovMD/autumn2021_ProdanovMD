package november26.homework;

public class OtherSolarSystemConfig {
    @Bean("Venus")
    public static Planet getPlanet2(){
        return new Planet("Venus");
    }
}
