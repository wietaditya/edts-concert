package com.edts.concerts.service.booking;

import com.edts.concerts.Repository.OrderRepository;
import com.edts.concerts.Repository.PackagesRepository;
import com.edts.concerts.dto.BaseResponse;
import com.edts.concerts.dto.booking.GetOrderResponseDto;
import com.edts.concerts.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GetOrderService {

    private final OrderRepository orderRepository;
    private final PackagesRepository packagesRepository;

    public GetOrderService(OrderRepository orderRepository, PackagesRepository packagesRepository) {
        this.orderRepository = orderRepository;
        this.packagesRepository = packagesRepository;
    }

    public BaseResponse<GetOrderResponseDto> getOrder(String orderId) {
        var order = orderRepository.findByOrderIdAndIsDeleted(orderId, Boolean.FALSE);
        if (order.isEmpty()) {
            throw new IllegalArgumentException("order not found");
        }

        var packages = packagesRepository.findById(order.get().getPackageId());
        if (packages.isEmpty()) {
            throw new IllegalArgumentException("package not found id : "
                    .concat(String.valueOf(order.get().getPackageId())));
        }

        GetOrderResponseDto result = new GetOrderResponseDto();
        result.setOrders(order.get());

        Double amountPayment = order.get().getQuantity() * packages.get().getPrice();
        result.setTotalAmount(amountPayment);

        return ResponseUtil.success(result);
    }
}
