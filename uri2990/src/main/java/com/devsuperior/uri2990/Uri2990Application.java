package com.devsuperior.uri2990;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import com.devsuperior.uri2990.repositories.EmpregadoRepository;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

	@Autowired
	private EmpregadoRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Query by SQL");
		List<EmpregadoDeptProjection> resultSQL = repository.searchBySql();
		resultSQL.stream()
			.map(x -> new EmpregadoDeptDTO(x))
			.forEach(System.out::println);;
		
		System.out.println("\n\n");
		
		System.out.println("Query by JPQL");
		List<EmpregadoDeptDTO> resultJPQL = repository.searchByJPQL();
		resultJPQL.stream()
			.forEach(System.out::println);;
	}
}
