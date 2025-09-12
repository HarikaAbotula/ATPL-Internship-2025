package com.aaslin.cbt.super_admin.utils;

public class CustomUserIdGenerator {

    public static String generateNextId(String lastId, String prefix) {
        if (lastId == null || lastId.isEmpty()) {
            return prefix + "001";
        }

        String numberPart = lastId.replaceAll("\\D", ""); // get digits only
        int num = Integer.parseInt(numberPart);

        return String.format(prefix + "%03d", num + 1);
    }
}

