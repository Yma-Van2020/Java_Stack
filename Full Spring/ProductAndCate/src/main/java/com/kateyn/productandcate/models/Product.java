package com.kateyn.productandcate.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


	@Entity
	@Table(name="products")
	public class Product {
		
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotNull
	    @Size(min = 2, message="name should be at least 2 chars long")
	    private String name;
	    
	    @NotNull
	    @Size(min = 3, message="description should be at least 3 chars long")
	    private String description;
	    
	    @NotNull
	    @Min(0)
	    private float price;
	    
	    @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    
	    @ManyToMany(fetch=FetchType.LAZY)
	    @JoinTable(
	    	name="categories_products",
	    	joinColumns = @JoinColumn(name="product_id"),
	    	inverseJoinColumns = @JoinColumn(name= "category_id")
	    )
	    private List<Category> categories;
	    
	    public Product() {}
	    
	    

		public Product(String name, String description, float price) {
			super();
			this.name = name;
			this.description = description;
			this.price = price;
		}



		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public List<Category> getCategories() {
			return categories;
		}

		public void setCategories(List<Category> categories) {
			this.categories = categories;
		};
	    
	    
	    
	}


