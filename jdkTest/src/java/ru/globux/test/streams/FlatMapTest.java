package ru.globux.test.streams;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FlatMapTest {

    record Region(String reg, List<String> cities) {}

    public static void main(String[] args) {

        List<String> cities1 = List.of("Moscow", "St.Petersburg", "Stalingrad", "Bryansk", "Perm");
        List<String> cities2 = List.of("Irkutsk", "Surgut", "Tyumen", "Novosibirsk", "E.burg");
        List<Region> regions = List.of(new Region("Europe", cities1), new Region("Asia", cities2));
        List<String> cities = regions
                .stream()
                .flatMap(reg -> reg.cities().stream())
                .toList();
        System.out.println(cities);

        BiConsumer<String, Consumer<String>> biCons = new BiConsumer<String, Consumer<String>>() {
            @Override
            public void accept(String str, Consumer<String> consumer) {
                consumer.accept(str);
            }
        };

        List<String> input = List.of("a", "b", "c");
        List<String> result = input.stream()
                .<String>mapMulti(biCons)
                .collect(Collectors.toList());
        System.out.println(result);


    }
}
