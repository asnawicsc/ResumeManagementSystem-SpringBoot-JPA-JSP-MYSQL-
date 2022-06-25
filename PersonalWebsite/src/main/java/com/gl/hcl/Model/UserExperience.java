package com.gl.hcl.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "userexperience")
public class UserExperience {
	// user experience attribute
	@Id
	private int id;
	private int user_id;
	private String company_name;
	private Date year_start;
	private Date year_end;
	private String experience_title;
	private String experience_desc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public Date getYear_start() {
		return year_start;
	}

	public void setYear_start(Date year_start) {
		this.year_start = year_start;
	}

	public Date getYear_end() {
		return year_end;
	}

	public void setYear_end(Date year_end) {
		this.year_end = year_end;
	}

	public String getExperience_title() {
		return experience_title;
	}

	public void setExperience_title(String experience_title) {
		this.experience_title = experience_title;
	}

	public String getExperience_desc() {
		return experience_desc;
	}

	public void setExperience_desc(String experience_desc) {
		this.experience_desc = experience_desc;
	}

}
