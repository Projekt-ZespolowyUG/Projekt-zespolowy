package com.pgs.soft.visit.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;
import com.pgs.soft.visit.validation.Phone;
import com.pgs.soft.visit.validation.Email;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue
	private int id;

	private String login;
	private String password;
	
	@OneToOne  
	@PrimaryKeyJoinColumn  
	private Employee employee;

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee emlpoyee) {
		this.employee = employee;
	}
	

}