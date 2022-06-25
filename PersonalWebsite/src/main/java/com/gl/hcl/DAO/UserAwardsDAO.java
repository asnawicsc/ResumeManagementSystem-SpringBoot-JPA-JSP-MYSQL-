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

import com.gl.hcl.Model.UserAwards;

@Service
public class UserAwardsDAO {
	JdbcTemplate templete;

	// function to call up database
	@Autowired
	public void setDataSource(DataSource datasource) {
		templete = new JdbcTemplate(datasource);
	}

	// function to get all user awards from database
	public List<UserAwards> getAllUserAwardsByUserID(int id) {
		String sql = "select * from userawards where user_id=" + id;

		return templete.query(sql, new ResultSetExtractor<List<UserAwards>>() {

			public List<UserAwards> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<UserAwards> list = new ArrayList<UserAwards>();
				while (rs.next()) {
					UserAwards u = new UserAwards();
					u.setId(rs.getInt(1));
					u.setUser_id(rs.getInt(2));
					u.setYear_start(rs.getDate(3));
					u.setYear_end(rs.getDate(4));
					u.setAwards_desc(rs.getString(5));

					list.add(u);
				}

				return list;
			}

		});
	}

	// function to add new user awards to database
	public void addNewUserAwards(UserAwards userawards) {
		String sql = "insert into userawards(user_id,year_start,year_end,awards_desc) values('"
				+ userawards.getUser_id() + "','" + userawards.getYear_start() + "','" + userawards.getYear_end()
				+ "','" + userawards.getAwards_desc() + "')";

		templete.update(sql);

	}

	// function to get user awards from database base on their id
	public UserAwards getUserAwardsByID(int id) {
		return templete.query("select * from userawards where ID=" + id, new ResultSetExtractor<UserAwards>() {

			public UserAwards extractData(ResultSet rs) throws SQLException, DataAccessException {
				UserAwards u = new UserAwards();
				while (rs.next()) {
					u.setId(rs.getInt(1));
					u.setUser_id(rs.getInt(2));
					u.setYear_start(rs.getDate(3));
					u.setYear_end(rs.getDate(4));
					u.setAwards_desc(rs.getString(5));

				}

				return u;
			}

		});
	}

	// function to update user awards to database
	public void updateUserAwards(UserAwards p) {
		String sql = "update userawards set user_id='" + p.getUser_id() + "',year_start='" + p.getYear_start()
				+ "',year_end='" + p.getYear_end() + "',awards_desc='" + p.getAwards_desc() + "' where ID=" + p.getId()
				+ "";

		templete.update(sql);

	}

	// function to delete user awards from database
	public void deleteUserAwards(int id) {
		String sql = "delete from userawards where ID=" + id + "";
		templete.update(sql);
	}

}
