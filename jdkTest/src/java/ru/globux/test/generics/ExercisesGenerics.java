package ru.globux.test.generics;

import java.util.*;

public class ExercisesGenerics {

    public static void main(String[] args) {
        Integer[] a = {1, 6, 4, 5, 9, 4, 3, 9, 3, 2, 9, 7, 8, 0, 4, 9};
        List<Integer> list = new ArrayList<>(Arrays.asList(a));
        System.out.println(countOdd(list, i -> i % 2 != 0));

        swap(a, 0, 1);
        System.out.println(Arrays.toString(a));

        System.out.println(maxInRange(list, 11, 14));
    }

    public static <T> int countOdd(Collection<T> list, UnaryPredicate<T> p) {
        int count = 0;
        for (T element: list) {
            if (p.test(element))
                ++count;
        }
        return count;
    }

    public static <T> void swap(T[] array, int i1, int i2) {
        T store = array[i1];
        array[i1] = array[i2];
        array[i2] = store;
    }

    public static <T> Comparable<T> maxInRange(List<? extends Comparable<T>> list, int begin, int end) {
        if (list.isEmpty())
            throw new IllegalArgumentException("List can not be empty");
        Comparable<T> max = list.get(begin);
        for (int i = begin; i <= end; i++) {
            Comparable<T> current = list.get(i);
            if (max.compareTo((T) current) < 0)
                max = current;
        }
        return max;
    }

    public static <T extends Object & Comparable<? super T>> T max(List<? extends T> list, int begin, int end) {
        T maxElem = list.get(begin);
        for (int i = begin + 1; i <= end; i++) {
            if (maxElem.compareTo(list.get(i)) < 0)
                maxElem = list.get(i);
        }
        return maxElem;
    }
}
