package com.studio3104.adventofcode2020.day02;

import java.util.Arrays;

abstract class Password {
    protected String password;
    protected char mustContain;
    protected int num1;
    protected int num2;
    protected boolean valid;

    abstract protected void validate();

    private void setParameters(String rule) {
        String[] r = rule.split(" ");

        password = r[2];
        mustContain = r[1].charAt(0);

        int[] nums = Arrays.stream(r[0].split("-")).mapToInt(Integer::parseInt).toArray();
        num1 = nums[0];
        num2 = nums[1];
    }

    public Password(String rule) {
        // rule: 1-3 a: abcde
        setParameters(rule);
        validate();
    }

    public boolean isValid() {
        return valid;
    }
}

class PasswordWithRule1 extends Password {
    @Override
    protected void validate()  {
        int count = 0;

        for (char c : password.toCharArray()) {
            if (c == mustContain) {
                ++count;
            }
            if (count > num2) {
                valid = false;
                return;
            }
        }

        valid = count >= num1;
    }

    public PasswordWithRule1(String rule) {
        super(rule);
    }
}

class PasswordWithRule2 extends Password {
    @Override
    protected void validate() {
        if (password.charAt(num1 - 1) == mustContain) {
            valid = password.charAt(num2 - 1) != mustContain;
        } else {
            valid = password.charAt(num2 - 1) == mustContain;
        }
    }

    public PasswordWithRule2(String rule) {
        super(rule);
    }
}