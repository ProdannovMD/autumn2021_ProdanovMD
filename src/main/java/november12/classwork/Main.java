package november12.classwork;

import november12.classwork.runnables.ChickenRunnable;
import november12.classwork.runnables.EggRunnable;

public class Main {
    public static void main(String[] args) {
        int iterations = 50;
        Thread chickenThread = new Thread(new ChickenRunnable(iterations));
        Thread eggThread = new Thread(new EggRunnable(iterations));

        chickenThread.start();
        eggThread.start();
    }
}
