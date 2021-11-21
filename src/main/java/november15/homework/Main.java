package november15.homework;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        int threadCnt = 10;
        Thread[] threads = new Thread[threadCnt];
        Forks forks = new Forks(5);
        for (int i = 0; i < threadCnt; i++) {
            int saturation = ThreadLocalRandom.current().nextInt(10) + 1;
            threads[i] = new Thread(new Philosopher("Философ" + (i + 1), saturation, forks));
            threads[i].start();
        }

    }
}
