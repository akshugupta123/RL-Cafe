package com.example.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "user_id")
	    private int id;
	    @NotNull
	    @Column(name = "user_name")
	    private String name;
	    @Column(name = "user_email")
	    private String email;
	    @Column(name = "user_mobilenumber")
	    private String mobile;
	    @Column(name = "user_address")
	    private String address;
	    @Column(name = "user_username")
	    private String username;
	    @Column(name = "user_password")
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
