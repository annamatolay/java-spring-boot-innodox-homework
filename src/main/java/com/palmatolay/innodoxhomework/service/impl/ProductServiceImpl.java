package com.palmatolay.innodoxhomework.service.impl;

import com.palmatolay.innodoxhomework.model.Product;
import com.palmatolay.innodoxhomework.repository.ProductRepository;
import com.palmatolay.innodoxhomework.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getById(Long id) {
		return productRepository.getOne(id);
	}

	@Override
	public Collection<Product> getByOwner(Long id) {
		return productRepository.findAllByOwnerId(id);
	}

	@Override
	public Collection<Product> getAll() {
		return productRepository.findAll();
	}

	@Override
	public Boolean delete(Long id) {
		productRepository.delete(getById(id));
		return !productRepository.existsById(id);
	}
}
