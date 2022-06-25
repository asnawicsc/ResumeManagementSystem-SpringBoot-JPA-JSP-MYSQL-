package com.gl.hcl.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "useracknowledgments")
public class UserAcknowledgments {
	// user acknowledgments attribute
	@Id
	private int id;
	private int user_id;
	private String acknowledgments_desc;
	private Date year;

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

	public String getAcknowledgments_desc() {
		return acknowledgments_desc;
	}

	public void setAcknowledgments_desc(String acknowledgments_desc) {
		this.acknowledgments_desc = acknowledgments_desc;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}
}
