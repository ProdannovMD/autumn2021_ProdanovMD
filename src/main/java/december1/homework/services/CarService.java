package december1.homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("carService")
public class CarService {

    private String name;
    private SomeService someService;

    public CarService(String name) {
        this.name = name;
    }

    @Autowired
    public CarService(@Qualifier("firstSomeService") SomeService someService) {
        this.someService = someService;
    }

    public CarService(String name, SomeService someService) {
        this.name = name;
        this.someService = someService;
    }

    public CarService() {

    }

    public SomeService getSomeService() {
        return someService;
    }
}
