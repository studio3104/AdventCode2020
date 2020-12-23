package com.studio3104.adventofcode2020.day23;

public class ListNode {
    public final int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode fromArray(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;

        for (int i = 1; i < nums.length; ++i) {
            ListNode node = new ListNode(nums[i]);
            current.next = node;
            current = node;
        }
        current.next = head;

        return head;
    }
}
