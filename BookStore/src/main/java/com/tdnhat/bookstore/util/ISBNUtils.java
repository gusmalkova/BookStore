package com.tdnhat.bookstore.util;


import java.util.Random;

public final class ISBNUtils {

    private static final Random RANDOM;

    static {
        RANDOM = new Random();
    }

    private ISBNUtils() {
    }

    /**
     * Generate ISBN. Ex:
     * "ISBN|356-1-28-592738-7"
     *
     * @return ISBN
     */
    public static String generate() {
        return String.format("ISBN|%s-%s-%s-%s-%s",
                             randomNumeric(3),
                             randomNumeric(1),
                             randomNumeric(2),
                             randomNumeric(6),
                             randomNumeric(1));
    }

    public static String getISBN(String isbn) {
        String[] arr = isbn.split("\\|");
        if (arr.length == 2) {
            return arr[1];
        } else {
            return "";
        }
    }

    private static String randomNumeric(int length) {
        if (length < 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(RANDOM.nextInt());
        }
        return sb.toString();
    }
}
