package com.kateyn.productandcate.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kateyn.productandcate.models.Product;
import com.kateyn.productandcate.services.CategoryService;
import com.kateyn.productandcate.services.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService pServ;
	
	@Autowired
	private CategoryService cServ;
	
	
	// ========== Display =======================
	@GetMapping("/products/new")
	public String newProd(@ModelAttribute("product") Product product) {
		return "creatProduct.jsp";
	}
	
	@GetMapping("products/{id}")
	public String displayProd(@PathVariable("id") Long id, Model model) {
		model.addAttribute("product", pServ.getOne(id));
		model.addAttribute("allCates", cServ.getAll());
		
		return "addCateToProd.jsp";
	}
	
	
	// ========== Action ========================
	@PostMapping("/products/create")
	public String createProd(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "creatProduct.jsp";
		} else {
			pServ.save(product);
			return "addCateToProd.jsp";
		}
	}
	
	@PostMapping("/products/{productId}/addCategory")
	public String addCate(@PathVariable("productId") Long productId, @RequestParam("cateId") Long cateId) {
		pServ.addToCate(productId, cateId);
		return "redirect:/products/" + productId;
	}
		
}
