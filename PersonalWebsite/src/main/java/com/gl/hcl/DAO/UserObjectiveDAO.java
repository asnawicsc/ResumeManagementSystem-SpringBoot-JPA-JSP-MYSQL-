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

import com.gl.hcl.Model.UserObjective;

@Service
public class UserObjectiveDAO {

	JdbcTemplate templete;

	// function to call up database
	@Autowired
	public void setDataSource(DataSource datasource) {
		templete = new JdbcTemplate(datasource);
	}

	// function to get all user objective from database
	public List<UserObjective> getAllUserObjectiveByUserID(int user_id) {
		System.out.println(user_id);
		String sql = "select * from userobjective where user_id=" + user_id;

		return templete.query(sql, new ResultSetExtractor<List<UserObjective>>() {

			public List<UserObjective> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<UserObjective> list = new ArrayList<UserObjective>();
				while (rs.next()) {
					UserObjective u = new UserObjective();
					u.setId(rs.getInt(1));
					u.setUser_id(rs.getInt(2));
					u.setObjective_desc(rs.getString(3));

					list.add(u);
				}

				return list;
			}

		});
	}

	// function to add new user objective to database
	public void addNewUserObjective(UserObjective userobjective) {
		String sql = "insert into userobjective(user_id,objective_desc) values('" + userobjective.getUser_id() + "','"
				+ userobjective.getObjective_desc() + "')";

		templete.update(sql);

	}

	// function to get user objective from database base on their id
	public UserObjective getUserObjectiveByID(int id) {
		return templete.query("select * from userobjective where ID=" + id, new ResultSetExtractor<UserObjective>() {

			public UserObjective extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserObjective u = new UserObjective();
				while (rs.next()) {
					u.setId(rs.getInt(1));
					u.setUser_id(rs.getInt(2));
					u.setObjective_desc(rs.getString(3));

				}

				return u;
			}

		});
	}

	// function to update user objective to database
	public void updateUserObjective(UserObjective userobjective) {
		String sql = "update userobjective set objective_desc='" + userobjective.getObjective_desc() + "' where ID="
				+ userobjective.getId() + "";

		templete.update(sql);

	}

	// function to delete user objective from database
	public void deleteUserObjective(int id) {
		String sql = "delete from userobjective where ID=" + id + "";
		templete.update(sql);
	}

}
