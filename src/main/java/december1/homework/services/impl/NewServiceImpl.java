package december1.homework.services.impl;

import december1.homework.services.SomeService;
import org.springframework.stereotype.Component;

@Component
public class NewServiceImpl implements SomeService {
    @Override
    public void doIt() {
        System.out.println("Я новая реализация, спасибо, что используете меня!!!");
    }
}
