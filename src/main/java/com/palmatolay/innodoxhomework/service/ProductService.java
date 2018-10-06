package com.palmatolay.innodoxhomework.service;

import com.palmatolay.innodoxhomework.dto.ProductDto;
import com.palmatolay.innodoxhomework.model.Product;

import java.util.Collection;

public interface ProductService {
	Product save(Product product);
	Product save(ProductDto productDto);
	Product getById(Long id);

	/**
	 * @param id refer to an exists account in the database
	 * @return all the products what belongs to the given account (return empty list if the accounts doesn't exists)
	 */
	Collection<Product> getByOwner(Long id);
	Collection<Product> getAll();

	/**
	 * @param id refer to an exists product in the database
	 * @return true if the deletion was successful, otherwise return false if the product still exists in the database
	 */
	Boolean delete(Long id);
}
