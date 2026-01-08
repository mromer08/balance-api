package com.mromer.balance.common.text;

public final class TextNormalizer {

    private TextNormalizer() {}

    public static String normalizeUppercase(String value) {
        if (value == null) return null;

        return value
                .trim()
                .replaceAll("\\s+", " ")
                .toUpperCase();
    }

    public static String normalizeEmailLowercase(String value) {
        if (value == null) return null;

        return value
                .trim()
                .toLowerCase();
    }
}

