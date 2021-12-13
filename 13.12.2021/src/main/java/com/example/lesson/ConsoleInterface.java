package com.example.lesson;

import com.example.lesson.model.Star;
import com.example.lesson.repository.StarRepository;
import javafx.scene.transform.Scale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

@Component
public class ConsoleInterface {
    private final StarRepository starRepository;

    @Autowired
    public ConsoleInterface(StarRepository starRepository) {
        this.starRepository = starRepository;
    }

    private void addStar(Scanner scanner) {
        System.out.print("Enter star name: ");
        String name = scanner.nextLine();
        Star newStar = new Star(name);
        starRepository.save(newStar);
    }

    private void getStarById(Scanner scanner) {
        System.out.print("Enter star id: ");
        try {
            int id = scanner.nextInt();
            Optional<Star> optionalStar = starRepository.findById(id);
            if (optionalStar.isPresent()) {
                System.out.println("Found star: " + optionalStar.get());
            } else {
                System.out.println("Star is not found");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Wrong input");
        }
    }

    private void getAllStars(Scanner scanner) {
        Iterable<Star> stars = starRepository.findAll();
        System.out.println("Found stars:");
        for (Star star : stars) {
            System.out.println(star);
        }
    }

    private void updateStarById(Scanner scanner) {
        System.out.print("Enter star id: ");
        try {
            int id = scanner.nextInt();
            Optional<Star> optionalStar = starRepository.findById(id);
            Star star;
            if (optionalStar.isPresent()) {
                star = optionalStar.get();
                System.out.println("Found star: " + star);
            } else {
                System.out.println("Star is not found");
                return;
            }
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            star.setName(name);
            starRepository.save(star);
            System.out.println("Star updated successfully");
        } catch (InputMismatchException e) {
            System.out.println("Error: Wrong input");
        }
    }

    private void deleteStarById(Scanner scanner) {
        System.out.print("Enter star id: ");
        try {
            int id = scanner.nextInt();
            Optional<Star> optionalStar = starRepository.findById(id);
            if (optionalStar.isPresent()) {
                System.out.println("Found star: " + optionalStar.get());
            } else {
                System.out.println("Star is not found");
                return;
            }
            starRepository.deleteById(id);
            System.out.println("Star deleted successfully");
        } catch (InputMismatchException e) {
            System.out.println("Error: Wrong input");
        }
    }

    @PostConstruct
    public void init() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            String command = scanner.nextLine().toLowerCase(Locale.ROOT);

            switch (command) {

                case "all":
                    getAllStars(scanner);
                    break;

                case "add":
                    addStar(scanner);
                    break;

                case "get":
                    getStarById(scanner);
                    break;

                case "delete":
                    deleteStarById(scanner);
                    break;

                case "update":
                    updateStarById(scanner);
                    break;

                case "quit" :
                    System.out.println("Exiting app");
                    quit = true;
                    break;

                default:
                    System.out.println("Unknown command");
            }
        }

    }
}
