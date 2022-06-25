package com.gl.hcl.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.hcl.DAO.UserEducationDAO;
import com.gl.hcl.Model.UserEducation;

@Service
public class UserEducationService implements IUserEducationService {

	@Autowired
	UserEducationDAO userEducationDAO;

	// function to get all user education by user id
	public List<UserEducation> getAllUserEducationByUserID(int id) {

		return userEducationDAO.getAllUserEducationByUserID(id);
	}

	// function to add new user education
	public void addNewUserEducation(UserEducation usereducation) {

		userEducationDAO.addNewUserEducation(usereducation);

	}

	// function to get user education by id
	public UserEducation getUserEducationByID(int id) {

		return userEducationDAO.getUserEducationByID(id);
	}

	// function to update user education
	public void updateUserEducation(UserEducation usereducation) {

		userEducationDAO.updateUserEducation(usereducation);
	}

	// function to delete user education
	public void deleteUserEducation(int id) {

		userEducationDAO.deleteUserEducation(id);
	}

}
