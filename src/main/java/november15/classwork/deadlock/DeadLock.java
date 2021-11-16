package november15.classwork.deadlock;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    static class Friend {
        private String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void sendBall(Friend catcher) {
            System.out.println(this.name + " sent ball to " + catcher.getName());
            catcher.getBall(this);
        }

        public synchronized void getBall(Friend receiver) {
            System.out.println(receiver.getName() + " got ball from " + this.name);
        }
    }

    public static void main(String[] args) {
        final Friend alex = new Friend("Alex");
        final Friend bob = new Friend("Bob");

        new Thread(() -> alex.sendBall(bob)).start();
        new Thread(() -> bob.sendBall(alex)).start();
    }
}
