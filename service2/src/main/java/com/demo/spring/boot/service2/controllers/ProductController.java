package com.demo.spring.boot.service2.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.boot.service2.entities.Product;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/products")
public class ProductController {
	final String base_URL = "http://localhost:8080/products";

	@Autowired
	RestTemplate restTemplate;

	@GetMapping
	public Iterable<Product> getProducts() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<Iterable<Product>> productResponse = restTemplate.exchange(base_URL, HttpMethod.GET, entity,
				new ParameterizedTypeReference<Iterable<Product>>() {
				});
		Iterable<Product> products = productResponse.getBody();
		return products;
	}

	@PostMapping
	public Product create(@RequestBody Product product) {
		// return restTemplate.postForObject( base_URL, product, Product.class);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<Product>(product, headers);
		return restTemplate.exchange(base_URL, HttpMethod.POST, entity, Product.class).getBody();
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") long id) {
		String new_URL = base_URL + "/" + id;
		// Map<String, String> params = new HashMap<String, String>();
		// params.put("id", "1");
		// return restTemplate.getForObject(new_URL, Product.class, params);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<Product>(headers);
		return restTemplate.exchange(new_URL, HttpMethod.GET, entity, Product.class).getBody();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") long id) {
		String new_URL = base_URL + "/" + id;
		// Map<String, String> params = new HashMap<String, String>();
		// params.put("id", "1");
		// restTemplate.delete(new_URL, params);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Product> entity = new HttpEntity<Product>(headers);
		restTemplate.exchange(new_URL, HttpMethod.DELETE, entity, Void.class).getBody();
	}
}
