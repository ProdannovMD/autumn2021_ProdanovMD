package november12.homework;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TimerThread thread = new TimerThread();
        thread.start();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();

            TimerCommands command;
            try {
                command = TimerCommands.valueOf(line.trim().toUpperCase(Locale.ROOT));
                if (command == TimerCommands.NONE)
                    continue;
            } catch (IllegalArgumentException e) {
                continue;
            }

            thread.executeCommand(command);
            if (command == TimerCommands.QUIT)
                break;
        }

    }
}
