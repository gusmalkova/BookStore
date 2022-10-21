package com.tdnhat.bookstore.book.entity;

public enum Permission {
    READ("read"),
    INSERT("insert"),
    DELETE("delete");

    private final String value;

    Permission(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
