package november12.classwork.runnables;

public class EggRunnable implements Runnable{
    private int iterations;

    public EggRunnable(int iterations) {
        this.iterations = iterations;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++) {
            System.out.println("Яйцо");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
