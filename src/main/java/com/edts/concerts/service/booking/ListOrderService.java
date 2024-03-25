package com.edts.concerts.service.booking;

import com.edts.concerts.Repository.ConcertRepository;
import com.edts.concerts.Repository.OrderRepository;
import com.edts.concerts.Repository.PackagesRepository;
import com.edts.concerts.dto.BaseResponse;
import com.edts.concerts.dto.booking.ListOrderResponseDto;
import com.edts.concerts.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ListOrderService {

    private final OrderRepository orderRepository;
    private final ConcertRepository concertRepository;
    private final PackagesRepository packagesRepository;

    public ListOrderService(OrderRepository orderRepository, ConcertRepository concertRepository, PackagesRepository packagesRepository) {
        this.orderRepository = orderRepository;
        this.concertRepository = concertRepository;
        this.packagesRepository = packagesRepository;
    }

    public BaseResponse<List<ListOrderResponseDto>> listMyOrders(String username) {
        log.info("start get list my order");

        var myOrders = orderRepository.findAllByUsernameAndIsDeleted(username, Boolean.FALSE);

        List<ListOrderResponseDto> result = new ArrayList<>();

        if (myOrders.size() == 0) {
            return ResponseUtil.success(result);
        }

        myOrders.forEach(order -> {
            var concert = concertRepository.findById(order.getConcertId());
            if (concert.isEmpty()) {
                throw new IllegalArgumentException("concert not found id : "
                        .concat(String.valueOf(order.getConcertId())));
            }

            var packages = packagesRepository.findById(order.getPackageId());
            if (packages.isEmpty()) {
                throw new IllegalArgumentException("package not found id : "
                        .concat(String.valueOf(order.getPackageId())));
            }

            ListOrderResponseDto myOrder = new ListOrderResponseDto();
            myOrder.setOrderId(order.getOrderId());

            myOrder.setConcertTitle(concert.get().getTitle());

            Double amountPayment = order.getQuantity() * packages.get().getPrice();
            myOrder.setAmountPayment(amountPayment);
            myOrder.setPaymentDeadline(order.getPaymentDeadline());
            result.add(myOrder);
        });

        return ResponseUtil.success(result);
    }
}
