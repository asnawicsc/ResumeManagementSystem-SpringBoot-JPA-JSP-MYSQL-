package com.gl.hcl.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "usereducation")
public class UserEducation {
	// user education attribute
	@Id
	private int id;
	private int user_id;
	private Date year_start;
	private Date year_end;
	private String education_title;
	private String education_desc;
	private Float grade;

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

	public String getEducation_title() {
		return education_title;
	}

	public void setEducation_title(String education_title) {
		this.education_title = education_title;
	}

	public String getEducation_desc() {
		return education_desc;
	}

	public void setEducation_desc(String education_desc) {
		this.education_desc = education_desc;
	}

	public Float getGrade() {
		return grade;
	}

	public void setGrade(Float grade) {
		this.grade = grade;
	}

}
