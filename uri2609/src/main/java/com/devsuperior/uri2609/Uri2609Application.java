package com.devsuperior.uri2609;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import com.devsuperior.uri2609.repositories.CategoryRepository;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
 
		System.out.println("Query by SQL");
		List<CategorySumProjection> resultSQL = repository.queryBySQL();
		resultSQL.stream()
			.map(x -> new CategorySumDTO(x))
			.forEach(System.out::println);
		
		System.out.println("\n\n");
		
		System.out.println("Query by JPQL");
		List<CategorySumDTO> resultJPQL = repository.queryByJPQL();
		resultJPQL.stream()
			.forEach(System.out::println);
	}
}
