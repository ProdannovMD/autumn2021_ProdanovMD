package november15.homework;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class Forks {
    private final Semaphore semaphore;
    private final Set<Thread> forkOwners = new HashSet<>();

    public Forks(int quantity) {
        semaphore = new Semaphore(quantity);
    }

    public void takeFork() {
        try {
            semaphore.acquire();
            forkOwners.add(Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void returnFork() {
        if (forkOwners.contains(Thread.currentThread())) {
            semaphore.release();
            forkOwners.remove(Thread.currentThread());
        }
    }
}
