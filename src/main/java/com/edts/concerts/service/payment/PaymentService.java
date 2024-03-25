package com.edts.concerts.service.payment;

import com.edts.concerts.Repository.OrderRepository;
import com.edts.concerts.Repository.PackagesRepository;
import com.edts.concerts.constant.OrderStatusEnum;
import com.edts.concerts.dto.BaseResponse;
import com.edts.concerts.dto.payment.PaymentRequestDto;
import com.edts.concerts.model.Orders;
import com.edts.concerts.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Slf4j
@Transactional
public class PaymentService {

    private final OrderRepository orderRepository;
    private final PackagesRepository packagesRepository;

    public PaymentService(OrderRepository orderRepository, PackagesRepository packagesRepository) {
        this.orderRepository = orderRepository;
        this.packagesRepository = packagesRepository;
    }

    public BaseResponse<Orders> payment(PaymentRequestDto requestDto) {
        log.info("start payment");
        var orderOpt = orderRepository.findByOrderIdAndIsDeleted(requestDto.getOrderId(), Boolean.FALSE);
        if (orderOpt.isEmpty()) {
            throw new IllegalArgumentException("order not found");
        }
        var order = orderOpt.get();

        var packagesOpt = packagesRepository.findById(order.getPackageId());
        if (packagesOpt.isEmpty()) {
            throw new IllegalArgumentException("package not found");
        }
        var packages = packagesOpt.get();

        try {
            if (packages.getQuota() < order.getQuantity()) {
                throw new IllegalArgumentException("insufficient quota");
            }

            order.setStatus(OrderStatusEnum.SUCCESS.getValue());
            order.setStatusDescription(OrderStatusEnum.SUCCESS.getDescription());
            order.setModifiedDate(new Date());
            order.setModifiedBy("System");

            var currentQuota = packages.getQuota() - order.getQuantity();
            packages.setQuota(currentQuota);

            orderRepository.save(order);
            packagesRepository.save(packages);
        } catch (Exception e) {
            e.printStackTrace();
            order.setStatus(OrderStatusEnum.FAILED.getValue());
            order.setStatusDescription(OrderStatusEnum.FAILED.getDescription());
            order.setModifiedDate(new Date());
            order.setModifiedBy("System");
            orderRepository.save(order);

            return ResponseUtil.failed(order);
        }

        return ResponseUtil.success(order);
    }
}
