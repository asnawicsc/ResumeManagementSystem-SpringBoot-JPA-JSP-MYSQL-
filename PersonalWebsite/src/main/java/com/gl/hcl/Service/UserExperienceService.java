package com.gl.hcl.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.hcl.DAO.UserExperienceDAO;

import com.gl.hcl.Model.UserExperience;

@Service
public class UserExperienceService implements IUserExperienceService {

	@Autowired
	UserExperienceDAO userExperienceDAO;

	// function to get all user experience by user id
	public List<UserExperience> getAllUserExperienceByUserID(int id) {

		return userExperienceDAO.getAllUserExperienceByUserID(id);
	}

	// function to add new user experience
	public void addNewUserExperience(UserExperience userexperience) {

		userExperienceDAO.addNewUserExperience(userexperience);

	}

	// function to get user experience by id
	public UserExperience getUserExperienceByID(int id) {

		return userExperienceDAO.getUserExperienceByID(id);
	}

	// function to update user experience
	public void updateUserExperience(UserExperience userexperience) {

		userExperienceDAO.updateUserExperience(userexperience);
	}

	// function to delete user experience
	public void deleteUserExperience(int id) {

		userExperienceDAO.deleteUserExperience(id);
	}
}
