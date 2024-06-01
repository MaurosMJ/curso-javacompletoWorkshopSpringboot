package com.whebsys.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whebsys.course.entities.OrderItem;
import com.whebsys.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
