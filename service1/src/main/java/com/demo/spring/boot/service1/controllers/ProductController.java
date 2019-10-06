package com.demo.spring.boot.service1.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.boot.service1.entities.Product;
import com.demo.spring.boot.service1.repos.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductRepository repository;

	@GetMapping
	public Iterable<Product> getProducts() {
		return repository.findAll();
	}

	@PostMapping
	public Product create(@RequestBody Product product) {
		return repository.save(product);
	}

	@GetMapping("/{id}")
	public Optional<Product> getProduct(@PathVariable("id") long id) {
		return repository.findById(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") long id) {
		repository.deleteById(id);
	}

}
