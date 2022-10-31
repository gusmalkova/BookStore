package com.tdnhat.bookstore.util;

public final class BillCodeUtils {

    private BillCodeUtils() {
    }

    /**
     * Generate bill code. Ex:
     * "BILL-1667234765494"
     *
     * @return bill code
     */
    public static String generate() {
        return "BILL-" + System.currentTimeMillis() % 3;
    }
}
