package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class AnagramResolver {
    private List<List<Character>> wordsList = new ArrayList<>();

    public void init() {
        try {
            wordsList = Arrays
                    .stream(Files.readString(Paths.get("./src/main/resources/wordlist.txt"))
                    .split(" "))
                    .filter(str -> !str.isBlank())
                    .map(this::toCharList)
                    .collect(toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Character> toCharList(String word) {
        return word.chars().boxed().map(code -> (char) code.intValue()).collect(toList());
    }

    public String findAnagramOf(String input) {
        var inputLetters = toCharList(input);
        return wordsList
                .stream()
                .filter(isAnagram(inputLetters))
                .findFirst()
                .stream()
                .flatMap(Collection::stream)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    private Predicate<List<Character>> isAnagram(List<Character> inputLetters) {
        return word -> word.size() == inputLetters.size() && inputLetters.containsAll(word);
    }

    public List<List<Character>> getWordsList() {
        return wordsList;
    }
}
