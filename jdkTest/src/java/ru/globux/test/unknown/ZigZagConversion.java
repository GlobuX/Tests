package ru.globux.test.unknown;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> build = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            build.add(new StringBuilder());
        }

        if (numRows == 2) {
            for (int i = 0; i < s.length(); i++) {
                build.get(i % 2).append(s.charAt(i));
            }
            return joinStrings(build);
        }

        //  6          4         2
        int splitter = numRows + (numRows - 2);
        int subSplitter = numRows - 1;
        for (int i = 0; i < s.length(); i++) {
            int currentSplitter = i % splitter;
            if (currentSplitter <= subSplitter) {
                build.get(currentSplitter).append(s.charAt(i));
            }
            else {
                build.get(splitter - currentSplitter).append(s.charAt(i));
            }
        }
        return joinStrings(build);
    }

    public static String joinStrings(List<StringBuilder> list) {
        StringBuilder sb = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
