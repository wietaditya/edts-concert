package com.edts.concerts.service.booking;

import com.edts.concerts.Repository.OrderRepository;
import com.edts.concerts.constant.OrderStatusEnum;
import com.edts.concerts.dto.BaseResponse;
import com.edts.concerts.dto.booking.CreateOrderRequestDto;
import com.edts.concerts.model.Orders;
import com.edts.concerts.model.Visitors;
import com.edts.concerts.utils.RandomUtil;
import com.edts.concerts.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@Transactional
public class CreateOrderService {

    private final OrderRepository orderRepository;

    public CreateOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public BaseResponse<Orders> createOrder(CreateOrderRequestDto requestDto) {
        log.info("create order");

        //TODO : parametrize
        Integer maxOrder = 4;
        Integer quantity = requestDto.getVisitors().size();

        if (quantity > maxOrder) {
            throw new IllegalArgumentException("quantity exceeds the maximum limit");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date = sdf.format(new Date());

        String orderId = null;
        while (true) {
            orderId = date.concat(RandomUtil.generateRandomAlphanumeric(5));
            var orderExist = orderRepository.findByOrderIdAndIsDeleted(orderId, Boolean.FALSE);
            if (orderExist.isEmpty()) {
                break;
            }
        }

        Date d = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        // TODO : parametrize minute
        cal.add(Calendar.MINUTE, 10);

        Orders orders = new Orders();
        orders.setOrderId(orderId);
        orders.setUsername(requestDto.getUsername());
        orders.setPackageId(requestDto.getPackageId());
        orders.setQuantity(quantity);
        orders.setStatus(OrderStatusEnum.WAITING_FOR_PAYMENT.getValue());
        orders.setStatusDescription(OrderStatusEnum.WAITING_FOR_PAYMENT.getDescription());
        orders.setPaymentDeadline(cal.getTime());

        orders.setCreatedBy(requestDto.getUsername());
        orders.setCreatedDate(new Date());
        orders.setModifiedBy(requestDto.getUsername());
        orders.setModifiedDate(new Date());
        orders.setIsDeleted(Boolean.FALSE);

        var visitorsDetail = requestDto.getVisitors();

        List<Visitors> visitorsList = new ArrayList<>();
        if (visitorsDetail.size()>0) {
            String finalOrderId = orderId;
            visitorsDetail.forEach(visitor -> {
                Visitors visitors = new Visitors();
                visitors.setOrderId(finalOrderId);
                visitors.setTitle(visitor.getTitle());
                visitors.setName(visitor.getName());
                visitors.setPhoneNumber(visitor.getPhoneNumber());
                visitors.setIdCardNumber(visitor.getIdCardNumber());

                visitorsList.add(visitors);
            });
        }

        orders.setVisitors(visitorsList);

        orderRepository.save(orders);

        return ResponseUtil.success(orders);
    }
}
