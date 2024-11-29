package ru.globux.test.lambda;

import java.util.function.Consumer;

public class ChainCompose {

    public static void main(String[] args) {
        Consumer<String> cons1 = s -> System.out.print(s + "1 ");
        Consumer<String> cons2 = s -> System.out.print(s + "2 ");
        cons1.andThen(cons2).accept("consumer");
    }
}
