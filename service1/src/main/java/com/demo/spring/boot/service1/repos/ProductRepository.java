package com.demo.spring.boot.service1.repos;

import org.springframework.data.repository.CrudRepository;

import com.demo.spring.boot.service1.entities.Product;

public interface ProductRepository extends CrudRepository<Product,Long> {

	
}
