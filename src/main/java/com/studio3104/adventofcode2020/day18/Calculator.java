package com.studio3104.adventofcode2020.day18;

import lombok.AllArgsConstructor;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

@AllArgsConstructor
public class Calculator {
    private final Set<Character> precedences;

    private void calculate(long num, char operator, Deque<Long> nums) {
        if (nums.isEmpty()) {
            nums.add(num);
            return;
        }

        if (!precedences.contains(operator)) {
            nums.add(num);
            return;
        }

        if (operator == '*') {
            nums.add(nums.pollLast() * num);
        }

        if (operator == '+') {
            nums.add(nums.pollLast() + num);
        }
    }

    private long calculate(String formula, int from, int to) {
        Deque<Long> nums = new ArrayDeque<>();

        long current = 0;
        char operator = '+';
        Deque<Integer> openAt = new ArrayDeque<>();

        for (int i = from; i < to; ++i) {
            char c = formula.charAt(i);

            if (c == ')') {
                if (openAt.isEmpty()) {
                    throw new RuntimeException("Invalidly structured formula");
                }
                current = calculate(formula, openAt.pollLast() + 1, i);
                continue;
            }

            if (c == '(') {
                openAt.add(i);
                continue;
            }

            if (Character.isSpaceChar(c) || !openAt.isEmpty()) {
                continue;
            }

            if (Character.isDigit(c)) {
                current = current * 10 + Character.getNumericValue(c);
                continue;
            }

            calculate(current, operator, nums);
            current = 0;
            operator = c;
        }

        calculate(current, operator, nums);
        return precedences.contains('*') ?
                nums.stream().mapToLong(n -> n).sum() :
                nums.stream().reduce(1L, (n, m) -> n * m);
    }

    public long calculate(String formula) {
        return calculate(formula, 0, formula.length());
    }
}
