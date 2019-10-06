package com.demo.spring.boot.service1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.spring.boot.service1.entities.Product;
import com.demo.spring.boot.service1.repos.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Service1ApplicationTests {

	@Autowired
	ApplicationContext context;
	
	@Test
	public void saveProduct(){
		ProductRepository repository = context.getBean(ProductRepository.class);
		Product product = new Product();
		product.setId(4L);
		product.setName("Apple Watch");
		product.setDescription("Good");
		product.setPrice(300d);
		repository.save(product);
	}

}
