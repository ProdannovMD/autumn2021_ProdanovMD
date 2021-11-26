package november26.classwork;

import java.util.List;

public class SolarSystem {
    private Star star;
    private List<Planet> planets;

    public SolarSystem(Star star, List<Planet> planets) {
        this.star = star;
        this.planets = planets;
    }

    @Override
    public String toString() {
        return "SolarSystem{" +
                "star=" + star +
                ", planets=" + planets +
                '}';
    }
}
