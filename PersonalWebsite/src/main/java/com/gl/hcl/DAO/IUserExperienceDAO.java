package com.gl.hcl.DAO;

import java.util.List;

import com.gl.hcl.Model.UserExperience;

//interface to list out all the function available in user experience
public interface IUserExperienceDAO {
	public List<UserExperience> getAllUserExperienceByUserID(int id);

	public void addNewUserExperience(UserExperience userexperience);

	public UserExperience getUserExperienceByID(int id);

	public void updateUserExperience(UserExperience userexperience);

	public void deleteUserExperience(int id);

}
