package com.playtech.agaponov;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String FULL_NAME_PATTERN = "^[^-][a-zA-Z\\-][^-]+\\s+[^-][a-zA-Z\\-]+[^-]$";
        String EMAIL_PATTERN = "^[a-zA-Z0-9.]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+";
        String PHONE_NUMBER_PATTERN = "\\+380\\d{2}\\d{7}";

        Map<String, String> fieldNameToPattern = new HashMap<String, String>() {{
            put("Full Name", FULL_NAME_PATTERN);
            put("Email", EMAIL_PATTERN);
            put("Phone Number", PHONE_NUMBER_PATTERN);
        }};

        Map<String, String> fieldNameToValue = new HashMap<>();

        for (String fieldName : fieldNameToPattern.keySet()) {
            System.out.format("Please enter your %s\n", fieldName);
            fieldNameToValue.put(fieldName, scanner.nextLine());
        }

        for (Map.Entry<String, String> entry : fieldNameToValue.entrySet()) {
            String fieldPattern = fieldNameToPattern.get(entry.getKey());

            if (!Pattern.matches(fieldPattern, entry.getValue())) {
                System.out.format("Entered invalid property %s with value %s\n", entry.getKey(), entry.getValue());
            }
        }
    }
}
