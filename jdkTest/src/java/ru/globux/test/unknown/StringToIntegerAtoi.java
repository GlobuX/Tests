package ru.globux.test.unknown;

public class StringToIntegerAtoi {

    public static void main(String[] args) {
        String s = "-91283472332";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        long result = 0;
        boolean isNegative = false;
        boolean isPositive = false;
        final char plus = '\u002B';
        final char minus = '\u002D';
        final char lesser = '\u002F';
        final char higher = '\u003A';
        final char zero = '\u0030';
        final char space = '\u0020';
        final char dot = '\u002E';
        final char[] ca = new char[s.length()];
        for (int i = 0; i < ca.length; i++) {
            ca[i] = s.charAt(i);
        }

        int ind = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = ca[i];
            ind++;
            if (ch == minus) {
                isNegative = true;
                if (isPositive) return 0;
                break;
            }
            else if (ch == plus) {
                isPositive = true;
                if (isNegative) return 0;
                break;
            }
            else if (ch == dot) {
                return 0;
            }
            else if (ch == space) {
                continue;
            }
            else if (ch > lesser && ch < higher) {
                result = result * 10L + (ch - zero);
                break;
            }
            else {
                return 0;
            }
        }
        for (int i = ind; i < s.length(); i++) {
            long ch = ca[i];
            if (ch > lesser && ch < higher) {
                result = result * 10L + (ch - zero);
                if (isNegative) {
                    if (-result < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                }
                else {
                    if (result > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }
            }
            else {
                break;
            }
        }
        if (isNegative) result = -result;

        return (int) result;
    }
}
