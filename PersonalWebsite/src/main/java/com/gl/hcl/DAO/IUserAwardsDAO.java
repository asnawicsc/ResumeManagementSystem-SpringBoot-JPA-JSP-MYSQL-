package com.gl.hcl.DAO;

import java.util.List;

import com.gl.hcl.Model.UserAwards;

//interface to list out all the function available in user awards
public interface IUserAwardsDAO {
	public List<UserAwards> getAllUserAwardsByUserID(int id);

	public void addNewUserAwards(UserAwards userawards);

	public UserAwards getUserAwardsByID(int id);

	public void updateUserAwards(UserAwards userawards);

	public void deleteUserAwards(int id);
}
