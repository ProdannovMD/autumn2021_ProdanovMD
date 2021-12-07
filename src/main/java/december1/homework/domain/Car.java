package december1.homework.domain;


import december1.homework.annotation.IntRandom;

import java.util.List;
import java.util.Optional;

public class Car {
    private String name;
    @IntRandom() private int id;
    private int age;

    private List<String> list;
    private Runnable run;

    public Car(String name) {
        this.name = name;
        System.out.println("Привет, я из вызвался из Spring Context для " + name);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void run() {
        Optional.ofNullable(run)
                .orElseThrow(() -> new IllegalStateException("Я не могу ехать, я не знаю как"));
        run.run();
    }

    public Runnable getRun() {
        return run;
    }

    public void setRun(Runnable run) {
        this.run = run;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", list=" + list +
                ", run=" + run +
                '}';
    }
}
