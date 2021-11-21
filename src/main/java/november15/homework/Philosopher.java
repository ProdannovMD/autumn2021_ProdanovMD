package november15.homework;

import java.util.concurrent.ThreadLocalRandom;

public class Philosopher implements Runnable {
    private static final String[] PHRASES = new String[]{
            "есть еду", "думает", "вспоминает прошлое", "размышляет о бытие"
    };
    private final String name;
    private final int saturation;
    private final Forks forks;

    public Philosopher(String name, int saturation, Forks forks) {
        this.name = name;
        this.saturation = saturation;
        this.forks = forks;
    }

    private void speak() {
        int i = ThreadLocalRandom.current().nextInt(PHRASES.length);
        System.out.println(name + " " + PHRASES[i]);
    }

    private void speak(String phrase) {
        System.out.println(name + " " + phrase);
    }

    @Override
    public void run() {
        forks.takeFork();
        speak("начал кушать");
        try {
            for (int i = 0; i < saturation; i++) {
                speak();
                Thread.sleep(1000L);
            }
        } catch (InterruptedException ignored) {
        }
        speak("закончил кушать");
        forks.returnFork();
    }
}
