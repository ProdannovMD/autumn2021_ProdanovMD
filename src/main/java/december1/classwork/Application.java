package december1.classwork;

import december1.classwork.domain.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new FileSystemXmlApplicationContext(
                        "C:\\Users\\Professional\\IdeaProjects\\NetCracker\\autumn2021_ProdanovMD\\src\\" +
                                "main\\resources\\december1\\beans.xml"
                );

//        Car car = applicationContext.getBean("car", Car.class);
        Car carChild = applicationContext.getBean("carChild", Car.class);
//        System.out.println(car);
        System.out.println(carChild);
    }
}
