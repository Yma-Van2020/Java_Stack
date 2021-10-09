package com.katelyn.ninjadojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.katelyn.ninjadojos.models.Dojo;
import com.katelyn.ninjadojos.repos.DojoRepo;

@Service
public class DojoServ {
	@Autowired
	private DojoRepo repo;
	
	//========== Create / Update ===============
	
	public Dojo save(Dojo dojo) {
		return repo.save(dojo);
	}
	
	// ========== Read ==========================
	
	public List<Dojo> getAll(){
		return repo.findAll();
	}
	
	
	public Dojo getOne(Long id) {
		Optional<Dojo> dojo = repo.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		} else {
			return null;
		}
	}
	
	// ========== Delete ========================
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
