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

import com.gl.hcl.Model.UserEducation;

@Service
public class UserEducationDAO {
	JdbcTemplate templete;

	// function to call up database
	@Autowired
	public void setDataSource(DataSource datasource) {
		templete = new JdbcTemplate(datasource);
	}

	// function to get all user education from database base on user id
	public List<UserEducation> getAllUserEducationByUserID(int user_id) {

		String sql = "select * from usereducation where user_id=" + user_id;

		return templete.query(sql, new ResultSetExtractor<List<UserEducation>>() {

			public List<UserEducation> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<UserEducation> list = new ArrayList<UserEducation>();
				while (rs.next()) {
					UserEducation u = new UserEducation();
					u.setId(rs.getInt(1));
					u.setUser_id(rs.getInt(2));
					u.setYear_start(rs.getDate(3));
					u.setYear_end(rs.getDate(4));
					u.setEducation_title(rs.getString(5));
					u.setEducation_desc(rs.getString(6));
					u.setGrade(rs.getFloat(7));

					list.add(u);
				}

				return list;
			}

		});
	}

	// function to add new user education to database
	public void addNewUserEducation(UserEducation usereducation) {
		String sql = "insert into usereducation(user_id,year_start,year_end,education_title,education_desc,grade) values('"
				+ usereducation.getUser_id() + "','" + usereducation.getYear_start() + "','"
				+ usereducation.getYear_end() + "','" + usereducation.getEducation_title() + "','"
				+ usereducation.getEducation_desc() + "','" + usereducation.getGrade() + "')";

		templete.update(sql);

	}

	// function to get user education from database base on their id
	public UserEducation getUserEducationByID(int id) {
		return templete.query("select * from usereducation where ID=" + id, new ResultSetExtractor<UserEducation>() {

			public UserEducation extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserEducation u = new UserEducation();
				while (rs.next()) {
					u.setId(rs.getInt(1));
					u.setUser_id(rs.getInt(2));
					u.setYear_start(rs.getDate(3));
					u.setYear_end(rs.getDate(4));
					u.setEducation_title(rs.getString(5));
					u.setEducation_desc(rs.getString(6));
					u.setGrade(rs.getFloat(7));

				}

				return u;
			}

		});
	}

	// function to update user education to database
	public void updateUserEducation(UserEducation p) {
		String sql = "update usereducation set user_id='" + p.getUser_id() + "',year_start='" + p.getYear_start()
				+ "',year_end='" + p.getYear_end() + "',education_title='" + p.getEducation_title()
				+ "',education_desc='" + p.getEducation_desc() + "',grade='" + p.getGrade() + "' where ID=" + p.getId()
				+ "";

		templete.update(sql);

	}

	// function to delete user education from database
	public void deleteUserEducation(int id) {
		String sql = "delete from usereducation where ID=" + id + "";
		templete.update(sql);
	}

}