package com.gl.hcl.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.hcl.DAO.UserAwardsDAO;
import com.gl.hcl.Model.UserAwards;

@Service
public class UserAwardsService implements IUserAwardsService {
	@Autowired
	UserAwardsDAO userAwardsDAO;

	// function to get all user awards by user id
	public List<UserAwards> getAllUserAwardsByUserID(int id) {

		return userAwardsDAO.getAllUserAwardsByUserID(id);
	}

	// function to add new user awards
	public void addNewUserAwards(UserAwards userawards) {

		userAwardsDAO.addNewUserAwards(userawards);

	}

	// function to get user awards by id
	public UserAwards getUserAwardsByID(int id) {

		return userAwardsDAO.getUserAwardsByID(id);
	}

	// function to update user awards
	public void updateUserAwards(UserAwards userawards) {

		userAwardsDAO.updateUserAwards(userawards);
	}

	// function to delete user awards
	public void deleteUserAwards(int id) {

		userAwardsDAO.deleteUserAwards(id);
	}
}
