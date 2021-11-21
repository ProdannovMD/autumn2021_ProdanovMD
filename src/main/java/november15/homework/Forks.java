package november15.homework;

import java.util.concurrent.Semaphore;

public class Forks {
    private int quantity;
    private Semaphore semaphore;

    public Forks(int quantity) {
        this.quantity = quantity;
        semaphore = new Semaphore(quantity);
    }

    public void takeFork() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void returnFork() {
        semaphore.release();
    }
}
