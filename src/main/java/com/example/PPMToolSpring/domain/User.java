//package com.example.PPMToolSpring.domain;
//
//import java.util.Collection;
//import java.util.Date;
//
////import org.springframework.security.core.Transient;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.PrePersist;
//import javax.persistence.PreUpdate;
//import javax.persistence.Transient;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//
//@Entity 
//public class User implements UserDetails  {
//
//	@Id 
//	@GeneratedValue(strategy = GenerationType.IDENTITY )
//	private Long id;
//	
//	@Email (message = "Username needs to be an email ")
//	@NotBlank(message = "username is required ")
//	@Column(name="username",unique = true )
//	private String username;
//	
//	@NotBlank(message = "Please enter your fullname ")
//	private String fullName;
//	@NotBlank(message = "Password is required. ")
//	private String password;
//	
//	@Transient 
////	@JsonIgnore 
//	private String confirmPassword;
//	
//	private Date create_At;
//	private Date update_At;
//	
//	
//	//OneToMany with project 
//	
//	
//	
//	
//	
//	@PrePersist 
//	protected void onCreate() {
//		this.create_At = new Date();
//	}
//	
//	@PreUpdate 
//	protected void onUpdate() {
//		this.update_At = new Date();
//	}
//	
//	/*
//	 UserDetails interface methods 
//	 */
//
//	
//	public User() {
//	}
//
//	@Override
//	@JsonIgnore 
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	@JsonIgnore
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		//return false;
//		return true;
//	}
//
//	@Override
//	@JsonIgnore
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		//return false;
//		return true;
//	}
//
//	@Override
//	@JsonIgnore
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		//return false;
//		return true;
//	}
//
//	@Override
//	@JsonIgnore
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		//return false;
//		
//		return true;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getFullName() {
//		return fullName;
//	}
//
//	public void setFullName(String fullName) {
//		this.fullName = fullName;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getConfirmPassword() {
//		return confirmPassword;
//	}
//
//	public void setConfirmPassword(String confirmPassword) {
//		this.confirmPassword = confirmPassword;
//	}
//
//	public Date getCreate_At() {
//		return create_At;
//	}
//
//	public void setCreate_At(Date create_At) {
//		this.create_At = create_At;
//	}
//
//	public Date getUpdate_At() {
//		return update_At;
//	}
//
//	public void setUpdate_At(Date update_At) {
//		this.update_At = update_At;
//	}
//	
//	
//	
//	
//
//	
//	
//}
