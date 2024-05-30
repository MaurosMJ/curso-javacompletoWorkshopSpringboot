package com.whebsys.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whebsys.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
}
