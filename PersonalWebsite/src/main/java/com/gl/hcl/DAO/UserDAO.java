package com.gl.hcl.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.gl.hcl.Model.User;

//user dao class
@Service
public class UserDAO {

	JdbcTemplate templete;

	// function to call up database
	@Autowired
	public void setDataSource(DataSource datasource) {
		templete = new JdbcTemplate(datasource);
	}

	// function to add new user
	public void addUser(User p) {
		String sql = "insert into user(personal_id,first_name,last_name,address,age,phone_number,email,img_src) values('"
				+ p.getPersonal_id() + "','" + p.getFirst_name() + "','" + p.getLast_name() + "','" + p.getAddress()
				+ "','" + p.getAge() + "','" + p.getPhone_number() + "','" + p.getEmail() + "','" + p.getImg_src()
				+ "')";

		templete.update(sql);

	}

	// function to get specific user by id
	public User getUserByID(int id) {
		return templete.query("select * from user where ID=" + id, new ResultSetExtractor<User>() {

			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User u = new User();
				while (rs.next()) {
					u.setId(rs.getInt(1));
					u.setPersonal_id(rs.getLong(2));
					u.setFirst_name(rs.getString(3));
					u.setLast_name(rs.getString(4));
					u.setAddress(rs.getString(5));
					u.setAge(rs.getInt(6));
					u.setPhone_number(rs.getLong(7));
					u.setEmail(rs.getString(8));
					u.setImg_src(rs.getString(9));

				}

				return u;
			}

		});
	}

	// function to get specific user by personal id
	public User getUserByPersonalID(long personal_id) {
		return templete.query("select * from user where personal_id=" + personal_id, new ResultSetExtractor<User>() {

			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User u = new User();
				while (rs.next()) {
					u.setId(rs.getInt(1));
					u.setPersonal_id(rs.getLong(2));
					u.setFirst_name(rs.getString(3));
					u.setLast_name(rs.getString(4));
					u.setAddress(rs.getString(5));
					u.setAge(rs.getInt(6));
					u.setPhone_number(rs.getLong(7));
					u.setEmail(rs.getString(8));
					u.setImg_src(rs.getString(9));

				}

				return u;
			}

		});
	}

	// function to update existing user
	public User updateUser(User p) {

		if (p.getImg_src() == null) {
			String sql = "update user set personal_id='" + p.getPersonal_id() + "',first_name='" + p.getFirst_name()
					+ "',last_name='" + p.getLast_name() + "',address='" + p.getAddress() + "',age='" + p.getAge()
					+ "',phone_number='" + p.getPhone_number() + "',email='" + p.getEmail() + "' where ID=" + p.getId()
					+ "";
			System.out.println(sql);
			templete.update(sql);
		} else {
			String sql = "update user set personal_id='" + p.getPersonal_id() + "',first_name='" + p.getFirst_name()
					+ "',last_name='" + p.getLast_name() + "',address='" + p.getAddress() + "',age='" + p.getAge()
					+ "',phone_number='" + p.getPhone_number() + "',email='" + p.getEmail() + "',img_src='"
					+ p.getImg_src() + "' where ID=" + p.getId() + "";
			System.out.println(sql);
			templete.update(sql);
		}

		return templete.query("select * from user where ID=" + p.getId(), new ResultSetExtractor<User>() {

			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User u = new User();
				while (rs.next()) {
					u.setId(rs.getInt(1));
					u.setPersonal_id(rs.getLong(2));
					u.setFirst_name(rs.getString(3));
					u.setLast_name(rs.getString(4));
					u.setAddress(rs.getString(5));
					u.setAge(rs.getInt(6));
					u.setPhone_number(rs.getLong(7));
					u.setEmail(rs.getString(8));
					u.setImg_src(rs.getString(9));

				}

				return u;
			}

		});

	}

	// function to delete user resume from database
	public void delete_resume(int user_id) {

		String sql = "delete from user where ID=" + user_id + "";
		templete.update(sql);

		String sql2 = "delete from useracknowledgments where user_id=" + user_id + "";
		templete.update(sql2);

		String sql3 = "delete from userawards where user_id=" + user_id + "";
		templete.update(sql3);

		String sql4 = "delete from usereducation where user_id=" + user_id + "";
		templete.update(sql4);

		String sql5 = "delete from userexperience where user_id=" + user_id + "";
		templete.update(sql5);

		String sql6 = "delete from userobjective where user_id=" + user_id + "";
		templete.update(sql6);

	}

}
