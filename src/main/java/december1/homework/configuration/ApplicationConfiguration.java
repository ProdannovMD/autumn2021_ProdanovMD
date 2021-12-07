package december1.homework.configuration;

import december1.homework.services.CarService;
import december1.homework.services.SomeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:december1/applicationContext.xml"})
@ComponentScan("december1.homework")
public class ApplicationConfiguration {

    @Bean
    public CarService carServiceNew(@Qualifier("newServiceImpl") SomeService someService) {
        return new CarService("я супер-пупер сервис машин", someService);
    }
}
