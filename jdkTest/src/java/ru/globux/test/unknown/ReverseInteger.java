package ru.globux.test.unknown;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(-1563847412));
    }

    public static int reverse(int x) {
        long reverse = 0;
        while (x != 0) {
            long remain = x % 10;
            reverse = reverse * 10L + remain;
            x = x / 10;
        }
        if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) return 0;
        return (int) reverse;
    }
}
