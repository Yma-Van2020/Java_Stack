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

import com.kateyn.productandcate.models.Category;
import com.kateyn.productandcate.services.CategoryService;
import com.kateyn.productandcate.services.ProductService;

@Controller
public class CateController {
	@Autowired 
	private CategoryService cServ;
	
	@Autowired
	private ProductService pServ;
	// ========== Display =======================
		@GetMapping("/categories/new")
		public String newCate( @ModelAttribute("category") Category category) {
			return "createCate.jsp";
		}
		
		@GetMapping("categories/{id}")
		public String displayCate(@PathVariable("id") Long id, Model model) {
			model.addAttribute("category", cServ.getOne(id));
			model.addAttribute("allProducts", pServ.getAll());
			
			return "addProdToCate.jsp";
		}
		
		// ========== Action ========================
		@PostMapping("/categories/create")
		public String createCate(@Valid @ModelAttribute("category") Category category, BindingResult result) {

			if(result.hasErrors()) {
				return "createCate.jsp";
			} else {
				cServ.save(category);
				return "addProdToCate.jsp";
			}
		}
		
		

		@PostMapping("/categories/{cateId}/addProduct")
		public String addProd(@PathVariable("cateId") Long cateId, @RequestParam("productId") Long productId) {
			cServ.addToProduct(cateId, productId);
			return "redirect:/categories/" + cateId;
		}
			
			
}
