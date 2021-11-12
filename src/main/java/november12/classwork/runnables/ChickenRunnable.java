package november12.classwork.runnables;

public class ChickenRunnable implements Runnable{
    private int iterations;

    public ChickenRunnable(int iterations) {
        this.iterations = iterations;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++) {
            System.out.println("Курица");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
