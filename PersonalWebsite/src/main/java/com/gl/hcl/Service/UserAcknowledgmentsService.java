package com.gl.hcl.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.hcl.DAO.UserAcknowledgmentsDAO;
import com.gl.hcl.Model.UserAcknowledgments;

@Service
public class UserAcknowledgmentsService implements IUserAcknowledgmentsService {
	@Autowired
	UserAcknowledgmentsDAO userAcknowledgmentsDAO;

	// function to get all user acknowledgments by user id
	public List<UserAcknowledgments> getAllUserAcknowledgmentsByUserID(int id) {

		return userAcknowledgmentsDAO.getAllUserAcknowledgmentsByUserID(id);
	}

	// function to add new user acknowledgments
	public void addNewUserAcknowledgments(UserAcknowledgments useracknowledgments) {

		userAcknowledgmentsDAO.addNewUserAcknowledgments(useracknowledgments);

	}

	// function to get user acknowledgments by id
	public UserAcknowledgments getUserAcknowledgmentsByID(int id) {

		return userAcknowledgmentsDAO.getUserAcknowledgmentsByID(id);
	}

	// function to update user acknowledgments
	public void updateUserAcknowledgments(UserAcknowledgments useracknowledgments) {

		userAcknowledgmentsDAO.updateUserAcknowledgments(useracknowledgments);
	}

	// function to delete user acknowledgments
	public void deleteUserAcknowledgments(int id) {

		userAcknowledgmentsDAO.deleteUserAcknowledgments(id);
	}

}
