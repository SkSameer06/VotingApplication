package com.sameer.spring.votingapp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users{
	@Id
	private Integer id = 0;
	private String username;
	private String password;
	private String email;
	private String pnum;
	private String status;
	private String votedTo;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getVotedTo() {
		return votedTo;
	}
	public void setVotedTo(String votedTo) {
		this.votedTo = votedTo;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", pnum="
				+ pnum + ", status=" + status + ", votedTo=" + votedTo + "]";
	}
	
	
	
	
}
