package ru.android_studio;

import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * В этом примере из набора нескольких списков из строк
 * мы получаем список уникальных слов
 */
public class Main {

    public static void main(String[] args) {
        Stream<String> stringStream1 = Stream.of("a d c", "b", "c");
        Stream<String> stringStream2 = Stream.of("d d d d a c v");
        Stream<String> stringStream3 = Stream.of("e");

        Function<String, Stream<String>> splitAsStream = line -> Pattern.compile(" ").splitAsStream(line);

        Stream.of(
                stringStream1,
                stringStream2,
                stringStream3
        )
        .flatMap(Function.identity())
        //.peek(System.out::println)
        .flatMap(splitAsStream)
        .collect(Collectors.toSet())
        .forEach(System.out::println);

        //printElements(stringStream1, stringStream2, stringStream3);
    }

    private static void printElements(Stream<String> stringStream1, Stream<String> stringStream2, Stream<String> stringStream3) {
        Function<Stream<String>, Stream<String>> function = stringStream -> stringStream;
        Stream.of(
                stringStream1,
                stringStream2,
                stringStream3
        )
        .flatMap(function)
        .forEach(System.out::println);
    }
}
