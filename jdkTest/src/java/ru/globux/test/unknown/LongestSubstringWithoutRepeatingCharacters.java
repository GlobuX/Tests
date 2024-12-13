package ru.globux.test.unknown;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("dvdf");
        System.out.println(length);
    }

    public static int lengthOfLongestSubstring(String s) {

        int result = 0;
        String longestString = "";
        int leftBound = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer rollBound = map.put(s.substring(i, i + 1), i);
            if (rollBound != null) {
                //leftBound = ++rollBound;
                String str = s.substring(rollBound, i);
                System.out.println(str);
                if (result < map.size()) {
                    result = map.size();
                }
                i = rollBound;
                map.clear();
            }
            else {
                if (result < map.size()) {
                    result = map.size();
                }
            }
        }
        return result;
    }
}
