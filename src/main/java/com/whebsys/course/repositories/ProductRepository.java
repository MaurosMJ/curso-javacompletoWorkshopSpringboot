package com.whebsys.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whebsys.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	
}
