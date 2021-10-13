package com.kateyn.projectManager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kateyn.projectManager.models.Project;
import com.kateyn.projectManager.models.User;
import com.kateyn.projectManager.repos.ProjectRepo;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepo pRepo;
	
	@Autowired
	private UserService uServ;
	
	//===create/update===
	public Project createProject(Project p) {
		return pRepo.save(p);
	}
	
	//===read===
	public List<Project> getAllProjects(){
		return pRepo.findAll();
	}
	
	public Project getProjectById(Long id) { //remember the optional 
		Optional<Project> optP = pRepo.findById(id);
		if(optP.isPresent()) {
			return optP.get();
		} else {
			return null;
		}
	}
	
//	public List<Project> getProjectsUserIsOnTeam(User user){
//		return pRepo.findByProjectMembers(user);
//	}
	
	public List<Project> getProjectsUserNotOnTeam(User user){
		return pRepo.findByProjectMembersNotContains(user);
	}
	//===delete===
	public void delete(Long id) {
		pRepo.deleteById(id);
	}
	
	//===others===
	
	public Project addToTeam(Long projectId, Long userId) {
		Project p = getProjectById(projectId);
		User u = uServ.getUserById(userId);
		
		p.getProjectMembers().add(u);
		return createProject(p);
	}
	
	public Project removeFromTeam(Long projectId, Long userId) {
		Project p = getProjectById(projectId);
		User u = uServ.getUserById(userId);
		
		p.getProjectMembers().remove(u);
		return createProject(p);
	}	
}
