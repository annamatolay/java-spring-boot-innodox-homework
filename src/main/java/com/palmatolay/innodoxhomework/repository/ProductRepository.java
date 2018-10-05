package com.palmatolay.innodoxhomework.repository;

import com.palmatolay.innodoxhomework.model.Account;
import com.palmatolay.innodoxhomework.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findByName(String name);
	Collection<Product> findAllByOwnerId(Long in);
}
