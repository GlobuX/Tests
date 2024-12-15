package ru.globux.test.unknown;

import java.util.concurrent.*;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaa"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        String longest = s.substring(0, 1);

        Callable<String> odd = new Callable<>() {
            @Override
            public String call() {
                String longestOdd = longest;
                for(int i = 1; i < s.length(); i++) {
                    //int length = i - firstIndex + 1;
                    for (int j = 1; j <= s.length() / 2; j++) {
                        int l = i - j;
                        int h = i + j;
                        if (l < 0 || h >= s.length()) break;
                        if (s.charAt(l) == s.charAt(h)) {
                            if (longestOdd.length() < h - l + 1) {
                                longestOdd = s.substring(l, h + 1);
                            }
                        }
                        else {
                            break;
                        }
                    }
                }
                return longestOdd;
            }
        };

        Callable<String> even = new Callable<>() {
            @Override
            public String call() {
                String longestEven = longest;
                for(int i = 0; i < s.length(); i++) {
                    for (int j = 0; j <= s.length() / 2; j++) {
                        int l = i - j;
                        int h = i + j + 1;
                        if (l < 0 || h >= s.length()) break;
                        if (s.charAt(l) == s.charAt(h)) {
                            if (longestEven.length() < h - l + 1) {
                                longestEven = s.substring(l, h + 1);
                            }
                        }
                        else {
                            break;
                        }
                    }
                }
                return longestEven;
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(2);
        Future<String> oddTask = pool.submit(odd);
        Future<String> evenTask = pool.submit(even);

        String oddStr = "";
        String evenStr = "";
        try {
            oddStr = oddTask.get();
            evenStr = evenTask.get();
        } catch (InterruptedException | ExecutionException e) {

        }
        pool.shutdown();


        return oddStr.length() > evenStr.length() ? oddStr : evenStr;
    }
}
