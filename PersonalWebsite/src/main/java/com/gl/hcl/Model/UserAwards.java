package com.gl.hcl.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "userawards")
public class UserAwards {
	// user awards attribute
	@Id
	private int id;
	private int user_id;
	private Date year_start;
	private Date year_end;
	private String awards_desc;

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

	public String getAwards_desc() {
		return awards_desc;
	}

	public void setAwards_desc(String awards_desc) {
		this.awards_desc = awards_desc;
	}

}
