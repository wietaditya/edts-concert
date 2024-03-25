package com.edts.concerts.dto.booking;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequestDto {
    private String username;
    private Long packageId;
    private List<VisitorsRequestDto> visitors;
}
