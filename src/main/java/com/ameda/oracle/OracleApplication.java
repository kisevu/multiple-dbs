package com.ameda.oracle;


import com.ameda.oracle.orders.entity.Order;
import com.ameda.oracle.orders.repository.OrderRepository;
import com.ameda.oracle.products.entity.Product;
import com.ameda.oracle.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;


@SpringBootApplication
public class OracleApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderRepository orderRepository;

	public static void main(String[] args) {
		SpringApplication.run(OracleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product = Product.builder()
				.productId(1)
				.name("Emma's basin")
				.price(20.00)
				.build();
		productRepository.save(product);

		Order order = Order.builder()
				.orderId(1)
				.fromWhom("kev")
				.orderDate(LocalDate.now())
				.build();

	}
}
