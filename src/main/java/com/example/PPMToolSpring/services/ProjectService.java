package com.example.PPMToolSpring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PPMToolSpring.domain.Backlog;
import com.example.PPMToolSpring.domain.Project;
import com.example.PPMToolSpring.domain.User;
import com.example.PPMToolSpring.exceptions.ProjectIdException;
import com.example.PPMToolSpring.exceptions.ProjectNotFoundException;
import com.example.PPMToolSpring.repositories.BacklogRepository;
import com.example.PPMToolSpring.repositories.ProjectRepository;
import com.example.PPMToolSpring.repositories.UserRepository;

@Service 
public class ProjectService {
	
	@Autowired 
	private ProjectRepository projectRepository;
	
	@Autowired 
	private BacklogRepository backlogRepository;
	
	@Autowired 
	UserRepository userRepository;
	
	public Project saveOrUpdateProject (Project project,String username) {
		
		if(project.getId() != null){
            Project existingProject = projectRepository.findByProjectIdentifier(project.getProjectIdentifier());
            if(existingProject !=null &&(!existingProject.getProjectLeader().equals(username))){
                throw new ProjectNotFoundException("Project not found in your account");
            }else if(existingProject == null){
                throw new ProjectNotFoundException("Project with ID: '"+project.getProjectIdentifier()+"' cannot be updated because it doesn't exist");
            }
        }
		
		
		try {
			
			User user = userRepository.findByUsername(username);
			project.setUser(user);
			project.setProjectLeader( user.getUsername());
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
	
	public Project findProjectByIdentifier (String projectId ,String username ) {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

		if(project == null ) {

			throw new ProjectIdException("Project ID"+projectId.toUpperCase()+"-does not exist.");
		}
		
		if(!project.getProjectLeader().equals(username )) {
			throw new ProjectNotFoundException("Project not found in your account");
		}
		
		
		return project;
	}
	
	
	public Iterable<Project > findAllProject(String username){
		return projectRepository.findAllByProjectLeader(username);
	}
	
	public void deleteProjectByIdentifier (String projectId ,String username ) {
//		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
//		
//		if(project == null ) {
//			throw new ProjectIdException("Canno Delete Project with id "+projectId + ". This project does not exist." );
//		}
		
		projectRepository.delete(findProjectByIdentifier(projectId, username ));
	}
	
	
	
	

}
