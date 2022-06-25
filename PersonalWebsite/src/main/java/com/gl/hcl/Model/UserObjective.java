package com.gl.hcl.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "userobjective")
public class UserObjective {
	// user objective attribute
	@Id
	private int id;
	private int user_id;
	private String objective_desc;

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

	public String getObjective_desc() {
		return objective_desc;
	}

	public void setObjective_desc(String objective_desc) {
		this.objective_desc = objective_desc;
	}

}
