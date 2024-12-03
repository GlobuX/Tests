package ru.globux.test.streams;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MapMultiTest {

    public static void main(String[] args) {

        List<String> in = List.of("a", "b", "c");
        List<String> res = in.stream()
                .<String>mapMulti((element, consumer) -> {
                    consumer.accept(element + "-1");
                    consumer.accept(element + "-2");
                })
                .collect(Collectors.toList());
        System.out.println(res);


//        List<String> input = List.of("d", "e", "f");
//        List<String> result = input.stream()
//                .<String>mapMulti(new BiConsumer<String, Consumer<String>>() {
//                    @Override
//                    public void accept(String str, Consumer<String> strConsumer) {
//                        strConsumer.accept(str + "-1");
//                        strConsumer.accept(str + "-2");
//                    }
//                })
//                .collect(Collectors.toList());
//        System.out.println(result);
    }
}
