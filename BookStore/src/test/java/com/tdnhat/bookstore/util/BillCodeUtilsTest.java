package com.tdnhat.bookstore.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BillCodeUtilsTest {

    @Test
    void generate() {
        String billCode = BillCodeUtils.generate();
        System.out.println(billCode);
        assertNotNull(billCode);
        assertTrue(billCode.startsWith("BILL-"));
    }
}