package com.gl.hcl.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "user")
public class User {
	// user attribute

	@Id
	private int id;
	private Long personal_id;
	private String first_name;
	private String last_name;
	private String email;
	private String address;
	private int age;
	private Long phone_number;
	@Column(nullable = true, length = 64)
	private String img_src;

	@Transient
	public String getPhotosImagePath() {
		if (img_src == null)
			return null;

		return "/user-photos/" + id + "/" + img_src;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getPersonal_id() {
		return personal_id;
	}

	public void setPersonal_id(Long i) {
		this.personal_id = i;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}

	public String getImg_src() {
		return img_src;
	}

	public void setImg_src(String img_src) {
		this.img_src = img_src;
	}

}
