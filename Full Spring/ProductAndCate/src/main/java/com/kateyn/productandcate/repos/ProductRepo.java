package com.kateyn.productandcate.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kateyn.productandcate.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long>{
	List<Product> findAll();
	
}
