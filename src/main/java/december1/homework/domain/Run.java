package december1.homework.domain;

public class Run implements Runnable {

    private String message;

    public Run(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(message);
    }
}
