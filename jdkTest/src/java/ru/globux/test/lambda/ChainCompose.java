package ru.globux.test.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class ChainCompose {

    public static void main(String[] args) {
        Consumer<String> cons1 = s -> System.out.print(s + "1 ");
        Consumer<String> cons2 = s -> System.out.println(s + "2 ");
        cons1.andThen(cons2).accept("consumer");

        UnaryOperator<String> un1 = s -> s + "01 ";
        UnaryOperator<String> un2 = s -> s + "02 ";
        UnaryOperator<String> un3 = s -> s + "03 ";
        String str = un1.compose(un2).compose(un3).apply("unaryOp");

        Consumer<String> printer = System.out::println;
        printer.accept(str);

        List<String> list = Arrays.asList("a", "b", "c");
        Map<String, String> map1 = list.stream()
                .collect(Collectors.toMap(Function.identity(), Function.identity()));
        System.out.println(map1);
    }
}
