package com.gl.hcl.Service;

import java.util.List;

import com.gl.hcl.Model.UserObjective;

//interface to list out all the function available in user objective
public interface IUserObjectiveService {

	public List<UserObjective> getAllUserObjectiveByUserID(int id);

	public void addNewUserObjective(UserObjective userobjective);

	public UserObjective getUserObjectiveByID(int id);

	public void updateUserObjective(UserObjective userobjective);

	public void deleteUserObjective(int id);
}
