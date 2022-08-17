package com.devsuperior.uri2737.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2737.entities.Lawyer;
import com.devsuperior.uri2737.projections.LawyerMinProjection;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {

	@Query(nativeQuery = true, value = "(SELECT  l.name,l.customers_number AS customersNumber "
			+ "FROM lawyers l "
			+ "WHERE l.customers_number = ( "
			+ "	SELECT MAX(customers_number) "
			+ "	FROM lawyers "
			+ ") "
			+ ") "
			+ "UNION ALL "
			+ "(SELECT  l.name,l.customers_number "
			+ "FROM lawyers l "
			+ "WHERE l.customers_number = ( "
			+ "	SELECT MIN(customers_number) "
			+ "	FROM lawyers "
			+ ") "
			+ ") "
			+ "UNION ALL "
			+ "(SELECT 'Average', ROUND(AVG(l.customers_number),0) "
			+ "FROM lawyers l) ")
	List<LawyerMinProjection> queryBySQL();
}
