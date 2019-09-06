package com.resttemplate.resttemplateintegration;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotNull
	private String name;
	
	private Date birthDate;
	
	private String country;
	
	
	protected  User() {
		
	}
	public User(Integer id, String name, Date birthDate, String country) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.country=country;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	
	

}
