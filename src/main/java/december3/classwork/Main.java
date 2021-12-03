package december3.classwork;

import november26.homework.SolarSystem;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("december3/beans.xml");
        SolarSystem solarSystem = applicationContext.getBean(SolarSystem.class);

        System.out.println(solarSystem);
    }
}
