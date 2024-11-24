package ru.globux.test.unknown;

import java.util.HashMap;
import java.util.Map;

public class Test2 {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        System.out.println(map);

        boolean b = map.replace(2, "two", "three");
        System.out.println(map);
        System.out.println(b);
    }
}
