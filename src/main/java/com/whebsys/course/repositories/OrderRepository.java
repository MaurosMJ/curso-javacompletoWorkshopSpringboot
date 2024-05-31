package com.whebsys.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whebsys.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	
}
