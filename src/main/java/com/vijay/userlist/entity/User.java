package com.vijay.userlist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	private String firstname;
	private String lastname;
	private String emailid;
	private String password;
	@Id
	private long employeeid;
	private String organization;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(long employeeid) {
		this.employeeid = employeeid;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", emailid=" + emailid + ", password="
				+ password + ", employeeid=" + employeeid + ", organization=" + organization + "]";
	}

	
}
