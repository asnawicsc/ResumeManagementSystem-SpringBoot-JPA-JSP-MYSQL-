package com.gl.hcl.DAO;

import java.util.List;

import com.gl.hcl.Model.UserObjective;

//interface to list out all the function available in user objective
public interface IUserObjectiveDAO {

	public List<UserObjective> getAllUserObjectiveByUserID(int id);

	public void addNewUserObjective(UserObjective userobjective);

	public UserObjective getUserObjectiveByID(int id);

	public void updateUserObjective(UserObjective userobjective);

	public void deleteUserObjective(int id);

}
