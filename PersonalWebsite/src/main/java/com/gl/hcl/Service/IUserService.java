package com.gl.hcl.Service;

import com.gl.hcl.Model.User;

//interface to list out all the function available in user
public interface IUserService {
	public void addUser(User p);

	public User getUserByID(int id);

	public User getUserByPersonalID(long personal_id);

	public User updateUser(User user);

	public void delete_resume(int user_id);
}
