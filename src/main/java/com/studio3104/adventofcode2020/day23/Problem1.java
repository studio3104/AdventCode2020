package com.studio3104.adventofcode2020.day23;

import java.util.HashMap;
import java.util.Map;

class Problem1 {
    static ListNode playGame(int[] input, int times) {
        ListNode head = ListNode.fromArray(input);
        ListNode current = head;

        Map<Integer, ListNode> listNodeOf = new HashMap<>();
        do {
            listNodeOf.put(current.val, current);
            current = current.next;
        } while (head != current);

        for (int i = 1; i <= times; ++i) {
            ListNode picked = current.next;
            current.next = picked.next.next.next;

            int dest = current.val == 1 ? input.length : current.val - 1;
            while (picked.val == dest || picked.next.val == dest || picked.next.next.val == dest) {
                dest = dest == 1 ? input.length : dest - 1;
            }

            ListNode target = listNodeOf.get(dest);
            picked.next.next.next = target.next;
            target.next = picked;
            current = current.next;
        }

        return listNodeOf.get(1).next;
    }

    static int getResult(int[] input) {
        ListNode current = playGame(input, 100);

        int result = 0;

        while (current.val != 1) {
            result = result * 10 + current.val;
            current = current.next;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getResult(new int[]{1, 9, 8, 7, 5, 3, 4, 6, 2}));
    }
}
