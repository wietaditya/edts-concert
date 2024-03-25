package com.edts.concerts.dto.booking;

import com.edts.concerts.model.Orders;
import lombok.Data;

@Data
public class GetOrderResponseDto {
    private Orders orders;
    private Double totalAmount;
}
