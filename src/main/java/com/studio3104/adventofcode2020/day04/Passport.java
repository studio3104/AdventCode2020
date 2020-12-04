package com.studio3104.adventofcode2020.day04;

import java.util.ArrayList;
import java.util.List;

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

    private boolean isValid;

    private void validate() {
        isValid = byr != null && iyr != null && eyr != null && hgt != null && hcl != null && ecl != null && pid != null;
    }

    private void setFields(String fields) {
        for (String field : fields.split(" ")) {
            String[] f = field.split(":");
            switch (f[0]) {
                case "cid": cid = Integer.parseInt(f[1]); break;
                case "byr": byr = Integer.parseInt(f[1]); break;
                case "iyr": iyr = Integer.parseInt(f[1]); break;
                case "eyr": eyr = Integer.parseInt(f[1]); break;
                case "hgt": hgt = f[1]; break;
                case "hcl": hcl = f[1]; break;
                case "ecl": ecl = f[1]; break;
                case "pid": pid = f[1]; break;
                default:
                    throw new RuntimeException();
            }
        }
    }

    public static List<Passport> getPassports(String[] passportStrings) {
        List<Passport> passports = new ArrayList<>();
        Passport passport = new Passport();

        for (String s : passportStrings) {
            if (!s.equals("")) {
                passport.setFields(s);
                continue;
            }

            passport.validate();
            passports.add(passport);
            passport = new Passport();
        }

        passport.validate();
        passports.add(passport);

        return passports;
    }
}
