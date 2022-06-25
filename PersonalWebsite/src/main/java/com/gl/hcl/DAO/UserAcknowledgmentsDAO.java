package com.gl.hcl.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;
import com.gl.hcl.Model.UserAcknowledgments;

@Service
public class UserAcknowledgmentsDAO {
	JdbcTemplate templete;

	// function to call up database
	@Autowired
	public void setDataSource(DataSource datasource) {
		templete = new JdbcTemplate(datasource);
	}

	// function to get all user acknowledgments from database
	public List<UserAcknowledgments> getAllUserAcknowledgmentsByUserID(int id) {
		String sql = "select * from useracknowledgments where user_id=" + id;

		return templete.query(sql, new ResultSetExtractor<List<UserAcknowledgments>>() {

			public List<UserAcknowledgments> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<UserAcknowledgments> list = new ArrayList<UserAcknowledgments>();
				while (rs.next()) {
					UserAcknowledgments u = new UserAcknowledgments();
					u.setId(rs.getInt(1));
					u.setUser_id(rs.getInt(2));
					u.setAcknowledgments_desc(rs.getString(3));
					u.setYear(rs.getDate(4));

					list.add(u);
				}

				return list;
			}

		});
	}

	// function to add new user acknowledgments to database
	public void addNewUserAcknowledgments(UserAcknowledgments useracknowledgments) {
		String sql = "insert into useracknowledgments(user_id,acknowledgments_desc,year) values('"
				+ useracknowledgments.getUser_id() + "','" + useracknowledgments.getAcknowledgments_desc() + "','"
				+ useracknowledgments.getYear() + "')";

		templete.update(sql);

	}

	// function to get user acknowledgments from database base on their id
	public UserAcknowledgments getUserAcknowledgmentsByID(int id) {
		return templete.query("select * from useracknowledgments where ID=" + id,
				new ResultSetExtractor<UserAcknowledgments>() {

					public UserAcknowledgments extractData(ResultSet rs) throws SQLException, DataAccessException {
						UserAcknowledgments u = new UserAcknowledgments();
						while (rs.next()) {
							u.setId(rs.getInt(1));
							u.setUser_id(rs.getInt(2));
							u.setAcknowledgments_desc(rs.getString(3));
							u.setYear(rs.getDate(4));

						}

						return u;
					}

				});
	}

	// function to update user acknowledgments to database
	public void updateUserAcknowledgments(UserAcknowledgments p) {

		String sql = "update useracknowledgments set user_id='" + p.getUser_id() + "',acknowledgments_desc='"
				+ p.getAcknowledgments_desc() + "',year='" + p.getYear() + "' where ID=" + p.getId() + "";

		templete.update(sql);

	}

	// function to delete user acknowledgments from database
	public void deleteUserAcknowledgments(int id) {
		String sql = "delete from useracknowledgments where ID=" + id + "";
		templete.update(sql);
	}

}
