package com.azld.model;

public class Book extends BookKey {
    private String describe;

    private String write;

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public String getWrite() {
        return write;
    }

    public void setWrite(String write) {
        this.write = write == null ? null : write.trim();
    }
}