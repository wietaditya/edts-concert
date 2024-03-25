package com.edts.concerts.constant;

public enum OrderStatusEnum {
    WAITING_FOR_PAYMENT("WAITING_FOR_PAYMENT", "Waiting for Payment"),
    EXPIRED("EXPIRED", "Expired"),
    SUCCESS("SUCCESS", "Success"),
    FAILED("FAILED", "Failed"),
    ;

    OrderStatusEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    private String value;
    private String description;


}
