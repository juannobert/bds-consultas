package com.devsuperior.uri2621;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import com.devsuperior.uri2621.repositories.ProductRepository;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Query SQL");
		List<ProductMinProjection> resultSQL = repository.searchBySQL(10, 20, "P");
		resultSQL.stream()
			.map(x -> new ProductMinDTO(x)).forEach(System.out::println);
		
		System.out.println("\n\n\n");
		
		List<ProductMinDTO> resultJPQl = repository.searchByJPQL(10, 20, "P");
		resultJPQl.stream()
			.forEach(System.out::println);
		
	}
}
