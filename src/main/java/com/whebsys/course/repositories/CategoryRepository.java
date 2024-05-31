package com.whebsys.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whebsys.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	
}
