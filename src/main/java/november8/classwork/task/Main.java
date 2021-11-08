package november8.classwork.task;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        VerbService verbService = VerbService.getInstance();
        List<Verb> verbList = verbService.getVerbs();

        Collections.shuffle(verbList);
        System.out.println("Все слова:");
        verbList.forEach(System.out::println);
        System.out.println();

        TreeSet<Verb> sortedVerbs = new TreeSet<>(
                Comparator.comparing(Verb::getRusName).thenComparing(Verb::getInfinitive)
        );

        sortedVerbs.addAll(verbList);

        Optional<Verb> firstSOptional = sortedVerbs.stream()
                .filter(v -> v.getRusName().toLowerCase(Locale.ROOT).startsWith("с")).findFirst();
        Verb firstS = firstSOptional.orElse(null);

        Optional<Verb> firstTOptional = sortedVerbs.stream()
                .filter(v -> v.getRusName().toLowerCase(Locale.ROOT).startsWith("т")).findFirst();
        Verb firstT = firstTOptional.orElse(null);

        System.out.println(firstS + " - первое слово, начнающееся с 'с'");
        System.out.println(firstT + " - первое слово, начнающееся с 'т'");

        NavigableSet<Verb> verbsFromS = sortedVerbs.subSet(
                new Verb("", "", "", "с"), true,
                new Verb("", "", "", "т"), false
        );
        NavigableSet<Verb> verbsFromT = sortedVerbs.subSet(
                new Verb("", "", "", "т"), true,
                new Verb("", "", "", "у"), false
        );
        System.out.println("\nСлова, начинающееся с 'с'");
        verbsFromS.forEach(System.out::println);
        System.out.println("\nСлова, начинающееся с 'т'");
        verbsFromT.forEach(System.out::println);

    }

}
