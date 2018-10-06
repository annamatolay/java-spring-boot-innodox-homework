package com.palmatolay.innodoxhomework.repository;

import com.palmatolay.innodoxhomework.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Part of the persistence layer what can access and modify products in the database
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findByName(String name);
	Collection<Product> findAllByOwnerId(Long in);
}
