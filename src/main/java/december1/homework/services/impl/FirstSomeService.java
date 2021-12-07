package december1.homework.services.impl;

import december1.homework.services.SomeService;
import december1.homework.annotation.Deprecated;
import org.springframework.stereotype.Component;

@Deprecated("december1.homework.services.impl.NewServiceImpl")
@Component
public class FirstSomeService implements SomeService {
    @Override
    public void doIt() {
        System.out.println("Я старая реализация, не используйте меня!!!");
    }
}
