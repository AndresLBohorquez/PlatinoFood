package com.platinosfood.backend.repositories;

import com.platinosfood.backend.entities.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {

}
