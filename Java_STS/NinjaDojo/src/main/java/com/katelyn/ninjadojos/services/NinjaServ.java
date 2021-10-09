package com.katelyn.ninjadojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.katelyn.ninjadojos.models.Ninja;
import com.katelyn.ninjadojos.repos.NinjaRepo;

@Service
public class NinjaServ {

	@Autowired
	private NinjaRepo repo;
	
	public Ninja save(Ninja ninja) {
		return repo.save(ninja);
	}
	
	public Ninja getOne(Long id) {
		Optional<Ninja> ninja = repo.findById(id);
		if(ninja.isPresent()) {
			return ninja.get();
		} else {
			return null;
		}
	}
	
	public List<Ninja> getAll(){
		return repo.findAll();
	}
	
}
