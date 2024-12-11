package ru.globux.test.unknown;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TwoSum {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(twoSum(new int[] {1, 2, 4, 6, 11, 11}, 3)));
    }

    public record Pair(int n, int i) {}

    public static int[] twoSum(int[] nums, int target) {

        System.out.println(8 / 10);
        System.out.println(8 % 10);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int hash = Objects.hash(target - nums[i]);
            System.out.println(i + " " + nums[i] + " " + hash);
            map.put(hash, i);
        }

        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int second = target - nums[i];
            int hash = Objects.hash(second);
            Integer i2 = map.get(hash);
            System.out.println(i + " " +second + " " + hash + " " + i2);
            if (i2 != null) {
                result[0] = i2;
                result[1] = i;
                //break;
            }
        }

        return result;
    }
}
