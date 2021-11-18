package november12.homework;

public class TimerThread extends Thread{
    private volatile int timer;
    private volatile TimerCommands command = TimerCommands.NONE;

    public TimerThread() {
        timer = 0;
    }

    @Override
    public void run() {
        outer:
        while (true) {
            try {
                if (isInterrupted()) {
                    throw new InterruptedException();
                }
                Thread.sleep(1000);
                System.out.println("Время с запуска программы: " + ++timer + " сек.");
            } catch (InterruptedException e) {
                switch (command) {
                    case RESTART:
                        restartCommand();
                        break;
                    case STOP:
                        stopCommand();
                        break;
                    case QUIT:
                        break outer;

                    default:
                }
            }
        }
    }

    public synchronized void executeCommand(TimerCommands command) {
        this.command = command;
        this.interrupt();
    }

    private void restartCommand() {
        timer = 0;
    }

    private synchronized void stopCommand() {
        outer:
        while (true) {
            try {
                if (isInterrupted())
                    throw new InterruptedException();
                wait();
            } catch (InterruptedException e) {
                switch (command) {
                    case RESTART:
                        restartCommand();
                        break outer;

                    case START:
                        break outer;

                    case QUIT:
                        interrupt();
                        break outer;

                    default:
                }
            }
        }
    }
}
