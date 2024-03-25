package com.edts.concerts.dto.booking;

import lombok.Data;

@Data
public class VisitorsRequestDto {
    private String title;
    private String name;
    private String phoneNumber;
    private String idCardNumber;
}