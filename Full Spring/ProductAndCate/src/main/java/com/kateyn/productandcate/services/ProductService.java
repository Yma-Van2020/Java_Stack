package com.kateyn.productandcate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kateyn.productandcate.models.Category;
import com.kateyn.productandcate.models.Product;
import com.kateyn.productandcate.repos.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo repo;
	
	@Autowired
	private CategoryService cateServ;
	
	// ========== Create / Update ===============

	public Product save(Product p) {
		return repo.save(p);
	}
	
	// ========== Read ==========================
	
	public List<Product> getAll(){
		return repo.findAll();
	}
	
	public Product getOne(Long id) {
		Optional<Product> p = repo.findById(id);
		if(p.isPresent()) {
			return p.get();
		} else {	
			return null;
		}
	}
	
	// ========== Relationships =================
	public Product addToCate(Long productId, Long cateId) {
		Product prod = getOne(productId);
		Category cate = cateServ.getOne(cateId);
		
		prod.getCategories().add(cate);
		return save(prod);
	}
	
}
