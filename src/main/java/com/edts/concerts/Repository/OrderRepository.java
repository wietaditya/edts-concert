package com.edts.concerts.Repository;

import com.edts.concerts.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    Optional<Orders> findByOrderIdAndIsDeleted(String orderId, Boolean isDeleted);
    List<Orders> findAllByUsernameAndIsDeleted(String username, Boolean isDeleted);

}
