package com.gl.hcl.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.hcl.DAO.UserObjectiveDAO;

import com.gl.hcl.Model.UserObjective;

//user service
@Service
public class UserObjectiveService implements IUserObjectiveService {

	@Autowired
	UserObjectiveDAO userObjectiveDAO;

	// function to get all user objective by user id
	public List<UserObjective> getAllUserObjectiveByUserID(int id) {

		return userObjectiveDAO.getAllUserObjectiveByUserID(id);
	}

	// function to add new user objective
	public void addNewUserObjective(UserObjective userobjective) {

		userObjectiveDAO.addNewUserObjective(userobjective);

	}

	// function to get user objective by id
	public UserObjective getUserObjectiveByID(int id) {

		return userObjectiveDAO.getUserObjectiveByID(id);
	}

	// function to update user objective
	public void updateUserObjective(UserObjective userobjective) {

		userObjectiveDAO.updateUserObjective(userobjective);
	}

	// function to delete user objective
	public void deleteUserObjective(int id) {

		userObjectiveDAO.deleteUserObjective(id);
	}

}
