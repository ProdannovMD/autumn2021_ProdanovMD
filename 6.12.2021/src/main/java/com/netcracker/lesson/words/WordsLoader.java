package com.netcracker.lesson.words;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordsLoader {
    public static Set<String> getWords(Path input) throws IOException {
        Set<String> words = new HashSet<>();
        Files.lines(input).forEach(line -> {
            String[] split = line.split("\\s+");
            words.addAll(Arrays.asList(split));
        });

        return words;
    }
}
