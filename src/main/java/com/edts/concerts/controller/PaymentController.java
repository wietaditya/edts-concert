package com.edts.concerts.controller;

import com.edts.concerts.dto.BaseResponse;
import com.edts.concerts.dto.payment.PaymentRequestDto;
import com.edts.concerts.model.Orders;
import com.edts.concerts.service.payment.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    @ResponseBody
    public BaseResponse<Orders> payment(@RequestBody PaymentRequestDto requestDto) {
        return paymentService.payment(requestDto);
    }
}
