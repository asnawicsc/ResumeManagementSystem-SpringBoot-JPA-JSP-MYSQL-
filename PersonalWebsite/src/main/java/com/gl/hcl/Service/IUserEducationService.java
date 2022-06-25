package com.gl.hcl.Service;

import java.util.List;

import com.gl.hcl.Model.UserEducation;

//interface to list out all the function available in user education
public interface IUserEducationService {
	public List<UserEducation> getAllUserEducationByUserID(int id);

	public void addNewUserEducation(UserEducation usereducation);

	public UserEducation getUserEducationByID(int id);

	public void updateUserEducation(UserEducation usereducation);

	public void deleteUserEducation(int id);
}
