package com.katelyn.ninjadojos.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import javax.validation.constraints.Size;
@Entity
@Table(name = "dojos")
public class Dojo {
	
	// ========== Primary Key ===================
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	// ========== Member Variables ==============
	@Size(min = 2, message="name should be at least 2 chars")
	private String name;
	
	 // ========== Relationships =================
	@OneToMany(mappedBy="dojo", fetch=FetchType.LAZY)
	private List<Ninja> ninjas;
	
    // ========== Data Creation Trackers ========
	@Column(updatable = false)
		private Date createdAt;
		private Date updatedAt;
		
	// ========== Constructors ===================
		public Dojo() {
			
		}

	public Dojo(@Size(min = 2, message = "name should be at least 2 chars") String name, List<Ninja> ninjas) {
		super();
		this.name = name;
		this.ninjas = ninjas;
	}
		
	// ========== Data Creation Event ===========
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}


	  // ========== Getters and Setters ===========
	
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

	public List<Ninja> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
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

	
}
