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

import com.gl.hcl.Model.UserExperience;

@Service
public class UserExperienceDAO {
	JdbcTemplate templete;

	// function to call up database
	@Autowired
	public void setDataSource(DataSource datasource) {
		templete = new JdbcTemplate(datasource);
	}

	// function to get all user experience from database
	public List<UserExperience> getAllUserExperienceByUserID(int id) {

		String sql = "select * from userexperience where user_id=" + id;

		return templete.query(sql, new ResultSetExtractor<List<UserExperience>>() {

			public List<UserExperience> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<UserExperience> list = new ArrayList<UserExperience>();
				while (rs.next()) {
					UserExperience u = new UserExperience();
					u.setId(rs.getInt(1));
					u.setUser_id(rs.getInt(2));
					u.setCompany_name(rs.getString(3));
					u.setYear_start(rs.getDate(4));
					u.setYear_end(rs.getDate(5));
					u.setExperience_title(rs.getString(6));
					u.setExperience_desc(rs.getString(7));

					list.add(u);
				}

				return list;
			}

		});
	}

	// function to add new user experience to database
	public void addNewUserExperience(UserExperience userexperience) {
		String sql = "insert into userexperience(user_id,company_name,year_start,year_end,experience_title,experience_desc) values('"
				+ userexperience.getUser_id() + "','" + userexperience.getCompany_name() + "','"
				+ userexperience.getYear_start() + "','" + userexperience.getYear_end() + "','"
				+ userexperience.getExperience_title() + "','" + userexperience.getExperience_desc() + "')";

		templete.update(sql);

	}

	// function to get user experience from database base on their id
	public UserExperience getUserExperienceByID(int id) {
		return templete.query("select * from userexperience where ID=" + id, new ResultSetExtractor<UserExperience>() {

			public UserExperience extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserExperience u = new UserExperience();
				while (rs.next()) {
					u.setId(rs.getInt(1));
					u.setUser_id(rs.getInt(2));
					u.setCompany_name(rs.getString(3));
					u.setYear_start(rs.getDate(4));
					u.setYear_end(rs.getDate(5));
					u.setExperience_title(rs.getString(6));
					u.setExperience_desc(rs.getString(7));

				}

				return u;
			}

		});
	}

	// function to update user experience to database
	public void updateUserExperience(UserExperience p) {
		String sql = "update userexperience set user_id='" + p.getUser_id() + "',company_name='" + p.getCompany_name()
				+ "',year_start='" + p.getYear_start() + "',year_end='" + p.getYear_end() + "',experience_title='"
				+ p.getExperience_title() + "',experience_desc='" + p.getExperience_desc() + "' where ID=" + p.getId()
				+ "";

		templete.update(sql);

	}

	// function to delete user experience from database
	public void deleteUserExperience(int id) {
		String sql = "delete from userexperience where ID=" + id + "";
		templete.update(sql);

	}

}
