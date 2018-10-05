package com.palmatolay.innodoxhomework.service;

import com.palmatolay.innodoxhomework.model.Product;

import java.util.Collection;

public interface ProductService {
	Product save(Product product);
	Product getById(Long id);
	Collection<Product> getByOwner(Long id);
	Collection<Product> getAll();
	Boolean delete(Long id);
}
