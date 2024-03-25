package com.edts.concerts.constant;

public enum ConcertStatusEnum {
    AVAILABLE("AVAILABLE"),
    EXPIRED("EXPIRED"),
    SOON("SOON");

    ConcertStatusEnum(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
