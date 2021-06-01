package com.erp.project.security.service.payload;

import java.util.Set;

public class SignupRequest {

	 
	    private String username;
	 
	
	    
	    private Set<String> role;
	    
	 
	    private String password;
	    
	    private String bureau ;
	  
	    public String getUsername() {
	        return username;
	    }
	 
	    public void setUsername(String username) {
	        this.username = username;
	    }
	 
	   
	 
	    public String getPassword() {
	        return password;
	    }
	 
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    
	    public Set<String> getRole() {
	      return this.role;
	    }
	    
	    public void setRole(Set<String> role) {
	      this.role = role;
	    }

		public String getBureau() {
			return bureau;
		}

		public void setBureau(String bureau) {
			this.bureau = bureau;
		}
	    
	    
}
