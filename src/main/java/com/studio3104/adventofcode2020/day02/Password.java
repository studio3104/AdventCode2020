package com.studio3104.adventofcode2020.day02;

import java.util.Arrays;

public class Password {
    private char mustAppear;
    private int least;
    private int most;
    private String password;
    private boolean valid;

    private void setParameters(String rule) {
        String[] r = rule.split(" ");

        password = r[2];
        mustAppear = r[1].charAt(0);

        int[] times = Arrays.stream(r[0].split("-")).mapToInt(Integer::parseInt).toArray();
        least = times[0];
        most = times[1];
    }

    private void validate() {
        int count = 0;

        for (char c : password.toCharArray()) {
            if (c == mustAppear) {
                ++count;
            }
            if (count > most) {
                valid = false;
                return;
            }
        }

        valid = count >= least;
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
