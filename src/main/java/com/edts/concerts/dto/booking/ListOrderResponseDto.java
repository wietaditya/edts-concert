package com.edts.concerts.dto.booking;

import lombok.Data;

import java.util.Date;

@Data
public class ListOrderResponseDto {
    private String orderId;
    private String concertTitle;
    private Double amountPayment;
    private Date paymentDeadline;
}
