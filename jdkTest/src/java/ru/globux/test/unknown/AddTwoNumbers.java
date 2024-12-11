package ru.globux.test.unknown;

import java.util.Arrays;

public class AddTwoNumbers {

    public static void main(String[] args) {

        int[] n1 = new int[] {9,0,1};
        int[] n2 = new int[] {8,7,5};

        ListNode l1 = new ListNode(n1[0]);
        for (int i = 1; i < n1.length; i++) {
            l1 = new ListNode(n1[i], l1);
        }

        ListNode l2 = new ListNode(n2[0]);
        for (int i = 1; i < n2.length; i++) {
            l2 = new ListNode(n2[i], l2);
        }

        ListNode l3 = addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n = getNumRecursive(l1) + getNumRecursive(l2);
        System.out.println("N = " + n);
        int[] nums = new int[30];
        int count;

        for(count = 0; count < nums.length; count++) {
            nums[count] = n % 10;
            n = n / 10;
            if (n == 0) break;
        }

        System.out.println(Arrays.toString(nums));

        ListNode result = new ListNode(nums[count]);
        for(int i = count - 1; i >= 0; i--) {
            result = new ListNode(nums[i], result);
        }
        return result;
    }

    public static int getNumRecursive(ListNode l) {
        int result = l.val;
        if (l.val != 0 && l.next != null) result = result + getNumRecursive(l.next) * 10;
        System.out.println(result);
        return result;
    }

}

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}