package com.gl.hcl.Service;

import java.util.List;

import com.gl.hcl.Model.UserAcknowledgments;

//interface to list out all the function available in user acknowledgments
public interface IUserAcknowledgmentsService {

	public List<UserAcknowledgments> getAllUserAcknowledgmentsByUserID(int id);

	public void addNewUserAcknowledgments(UserAcknowledgments useracknowledgments);

	public UserAcknowledgments getUserAcknowledgmentsByID(int id);

	public void updateUserAcknowledgments(UserAcknowledgments useracknowledgments);

	public void deleteUserAcknowledgments(int id);
}
