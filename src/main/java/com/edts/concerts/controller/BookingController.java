package com.edts.concerts.controller;

import com.edts.concerts.dto.BaseResponse;
import com.edts.concerts.dto.booking.CreateOrderRequestDto;
import com.edts.concerts.dto.booking.GetOrderResponseDto;
import com.edts.concerts.dto.booking.ListOrderResponseDto;
import com.edts.concerts.model.Orders;
import com.edts.concerts.service.booking.CreateOrderService;
import com.edts.concerts.service.booking.GetOrderService;
import com.edts.concerts.service.booking.ListOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final CreateOrderService createOrderService;
    private final ListOrderService listOrderService;
    private final GetOrderService getOrderService;

    public BookingController(CreateOrderService createOrderService, ListOrderService listOrderService, GetOrderService getOrderService) {
        this.createOrderService = createOrderService;
        this.listOrderService = listOrderService;
        this.getOrderService = getOrderService;
    }

    @PostMapping("/createOrder")
    @ResponseBody
    BaseResponse<Orders> createOrder(@RequestBody CreateOrderRequestDto requestDto) {
        return createOrderService.createOrder(requestDto);
    }

    @GetMapping("/list")
    @ResponseBody
    BaseResponse<List<ListOrderResponseDto>> listMyOrder(String username) {
        return listOrderService.listMyOrders(username);
    }

    @GetMapping("/getOrder")
    @ResponseBody
    BaseResponse<GetOrderResponseDto> getOrder(String orderId) {
        return getOrderService.getOrder(orderId);
    }
}
