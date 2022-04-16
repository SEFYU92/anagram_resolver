package org.example;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        var anagramFinder = new AnagramResolver();
        anagramFinder.init();
        Arrays.stream(args).findFirst().ifPresent(arg -> System.out.println(anagramFinder.findAnagramOf(arg)));
    }
}

