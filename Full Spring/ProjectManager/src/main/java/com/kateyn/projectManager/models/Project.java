package com.kateyn.projectManager.models;

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
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message="Title must be provided")
    private String title;
    
    @NotNull
    @Size(min=3, message="description must be at least 3 chars")
    private String description;
    
    @NotNull(message="Due Date must be provided")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dueDate;
    
    @NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User lead;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	name="users_projects",
    	joinColumns=@JoinColumn(name="project_id"),
    	inverseJoinColumns= @JoinColumn(name="user_id")
    	)
    private List<User> projectMembers;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    public Project() {}

	public Project(@NotNull(message = "Title must be provided") String title,
			@NotNull @Size(min = 3, message = "description must be at least 3 chars") String description,
			@NotNull(message = "Due Date must be provided") Date dueDate, @NotNull User lead) {
		super();
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.lead = lead;
	};
    
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public User getLead() {
		return lead;
	}

	public void setLead(User lead) {
		this.lead = lead;
	}

	public List<User> getProjectMembers() {
		return projectMembers;
	}

	public void setProjectMembers(List<User> projectMembers) {
		this.projectMembers = projectMembers;
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
