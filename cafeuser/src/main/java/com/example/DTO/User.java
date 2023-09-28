package com.example.DTO;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class User {
	
	   
	   
	    private int id;
	   
	    private String name;
	  
	    private String email;
	   
	    private String mobile;
	
	    private String address;
	    
	    private String username;
	  
	    private String password;
	    
	    public User(int id, String name, String email, String mobile, String address, String username,
				String password) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.mobile = mobile;
			this.address = address;
			this.username = username;
			this.password = password;
		}
		public User() {
	    	
	    }
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
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
		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", address="
					+ address + ", username=" + username + ", password=" + password + "]";
		}
	    


}
