package com.kateyn.productandcate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kateyn.productandcate.models.Category;
import com.kateyn.productandcate.models.Product;
import com.kateyn.productandcate.repos.CategoryRepo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo repo;
	
	@Autowired
	private ProductService pServ;
	
	// ========== Create / Update ===============
	public Category save(Category c) {
		return repo.save(c);
	}
	
	// ========== Read ==========================
	public List<Category> getAll(){
		return repo.findAll();
	}
	
	public Category getOne(Long id) {
		Optional<Category> c = repo.findById(id);
		if(c.isPresent()) {
			return c.get();
		} else {
			return null;
		}
	}
	
	public Category addToProduct(Long cateId, Long productId) {
		Product prod = pServ.getOne(productId);
		Category cate = getOne(cateId);
		
		cate.getProducts().add(prod);
		return save(cate);
	}
}
