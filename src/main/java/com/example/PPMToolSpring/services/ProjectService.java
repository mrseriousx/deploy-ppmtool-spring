package com.example.PPMToolSpring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PPMToolSpring.domain.Backlog;
import com.example.PPMToolSpring.domain.Project;
import com.example.PPMToolSpring.exceptions.ProjectIdException;
import com.example.PPMToolSpring.repositories.BacklogRepository;
import com.example.PPMToolSpring.repositories.ProjectRepository;

@Service 
public class ProjectService {
	
	@Autowired 
	private ProjectRepository projectRepository;
	
	@Autowired 
	private BacklogRepository backlogRepository;
	
	public Project saveOrUpdateProject (Project project) {
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			
			if(project.getId()==null ) {
				Backlog backlog = new Backlog();
				project.setBacklog(backlog);
				backlog.setProject(project );
				backlog.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			}
			
			if(project.getId()!=null) {
				project.setBacklog( backlogRepository.findByProjectIdentifier(project.getProjectIdentifier().toUpperCase()));
			}
			
			
			return projectRepository.save(project );	
		}catch(Exception e ) {
			throw new ProjectIdException("Project ID = "+project.getProjectIdentifier().toUpperCase()+" exist.");
		}
		
		
	}
	
	public Project findProjectByIdentifier (String projectId ) {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		System.out.print("22222 ");

		if(project == null ) {
			System.out.print("333333 ");

			throw new ProjectIdException("Project ID"+projectId.toUpperCase()+"-does not exist.");
		}
		return project;
	}
	
	
	public Iterable<Project > findAllProject(){
		return projectRepository.findAll();
	}
	
	public void deleteProjectByIdentifier (String projectId ) {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		
		if(project == null ) {
			throw new ProjectIdException("Canno Delete Project with id "+projectId + ". This project does not exist." );
		}
		
		projectRepository.delete(project);
	}
	
	
	
	

}
