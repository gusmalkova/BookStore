package com.tdnhat.bookstore.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ISBNUtilsTest {

    @Test
    void generate() {
        String isbn = ISBNUtils.generate();
        System.out.println(isbn);
        assertNotNull(isbn);
        assertTrue(isbn.startsWith("ISBN|"));
    }
}