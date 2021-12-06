package com.netcracker.lesson.words;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    private static Path wordsPath = Paths.get("C:\\Users\\Professional\\IdeaProjects\\NetCracker\\autumn2021_ProdanovMD\\6.12.2021\\src\\main\\resources\\russian_nouns.txt");

    private static Queue<Character> getChars(String s) {
        char[] chars = new char[s.length()];
        s.getChars(0, s.length(), chars, 0);
        Queue<Character> result = new PriorityQueue<>();
        for (char aChar : chars) {
            result.add(aChar);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово");
        String inputWord = scanner.nextLine();

        Set<String> words = WordsLoader.getWords(wordsPath);
        System.out.println(words.size());

        List<String> result = new ArrayList<>();

        for (String word : words) {
            Queue<Character> chars = getChars(word);
            Queue<Character> inputChars = getChars(inputWord);
            if (word.length() > 2 && inputChars.size() >= chars.size()) {
                boolean found = true;
                while (chars.size() > 0) {
                    if (!inputChars.remove(chars.remove())) {
                        found = false;
                        break;
                    }
                }
                if (found)
                    result.add(word);
            }
        }

        System.out.println("Найдено " + result.size() + " слов");
        Collections.sort(result);
        System.out.println("=========sorted");
        for (String res : result) {
            System.out.println(res);
        }
    }
}
