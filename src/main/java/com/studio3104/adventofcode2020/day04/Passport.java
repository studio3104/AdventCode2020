package com.studio3104.adventofcode2020.day04;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@lombok.Getter
public class Passport {
    private Integer cid;  // (Country ID)
    private Integer byr;  // (Birth Year)
    private Integer iyr;  // (Issue Year)
    private Integer eyr;  // (Expiration Year)
    private String hgt;   // (Height)
    private String hcl;   // (Hair Color)
    private String ecl;   // (Eye Color)
    private String pid;   // (Passport ID)

    private void setFields(String fields) {
        for (String field : fields.split(" ")) {
            String[] f = field.split(":");
            switch (f[0]) {
                case "cid":
                    cid = Integer.parseInt(f[1]);
                    break;
                case "byr":
                    byr = Integer.parseInt(f[1]);
                    break;
                case "iyr":
                    iyr = Integer.parseInt(f[1]);
                    break;
                case "eyr":
                    eyr = Integer.parseInt(f[1]);
                    break;
                case "hgt":
                    hgt = f[1];
                    break;
                case "hcl":
                    hcl = f[1];
                    break;
                case "ecl":
                    ecl = f[1];
                    break;
                case "pid":
                    pid = f[1];
                    break;
                default:
                    throw new RuntimeException();
            }
        }
    }

    private boolean validateHgt() {
        String unit = hgt.substring(hgt.length() - 2);

        int n;
        try {
            n = Integer.parseInt(hgt.substring(0, hgt.length() - 2));
        } catch (NumberFormatException e) {
            return false;
        }

        if (unit.equals("cm")) {
            return n >= 150 && n <= 193;
        }

        if (unit.equals("in")) {
            return n >= 59 && n <= 76;
        }

        return false;
    }

    private boolean validateHcl() {
        if (hcl.charAt(0) != '#' || hcl.length() != 7) {
            return false;
        }

        try {
            Integer.parseInt(hcl.substring(1), 16);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    private boolean validateEcl() {
        return Set.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(ecl);
    }

    private boolean validatePid() {
        if (pid.length() != 9) {
            return false;
        }

        try {
            Integer.parseInt(pid);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public boolean validate(boolean strict) {
        boolean containsAllRequiredFields = byr != null && iyr != null && eyr != null && hgt != null && hcl != null && ecl != null && pid != null;

        if (!strict) {
            return containsAllRequiredFields;
        }

        return containsAllRequiredFields &&
                byr >= 1920 && byr <= 2002 &&
                iyr >= 2010 && iyr <= 2020 &&
                eyr >= 2020 && eyr <= 2030 &&
                validateHgt() &&
                validateHcl() &&
                validateEcl() &&
                validatePid();
    }

    public static List<Passport> getPassports(String[] passportStrings) {
        List<Passport> passports = new ArrayList<>();
        Passport passport = new Passport();

        for (String s : passportStrings) {
            if (!s.equals("")) {
                passport.setFields(s);
                continue;
            }

            passports.add(passport);
            passport = new Passport();
        }

        passports.add(passport);
        return passports;
    }
}
