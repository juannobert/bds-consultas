package com.devsuperior.uri2611;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Autowired
	private MovieRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Query SQL");
		List<MovieMinProjection> resultSQL = repository.queryBySQL("Action");
		resultSQL.stream().map(x -> new MovieMinDTO(x)).forEach(System.out::println);
		
		System.out.println("\n\n\n");
		
		System.out.println("Query JPQL");
		List<MovieMinDTO> resultJPQL = repository.queryByJPQL("Action");
		resultJPQL.stream().forEach(System.out::println);
		
		
		
	}
}
