package com.cpted.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cpted.base.BaseDaoImplement;
import com.cpted.beans.ChargedAreaBean;

public class OrganizationDaoImplement extends BaseDaoImplement implements
		OrganizationDao {

	Connection connection = null;
	String sql = "";

	// 회원가입
	public boolean SignUp(String id, String password, String name, String code, String etc) throws Exception {
		// TODO Auto-generated method stub
		boolean ret = false;
		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;
			sql = "insert into  center(id,password,name,code,etc) values(?,?,?,?,?)";
			try {

				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cpteddb", "root",
						"gpem4162");
				if (connection != null) {

					statement = connection.prepareStatement(sql);

					statement.setString(1, id);
					statement.setString(2, password);
					statement.setString(3, name);
					statement.setString(4, code);
					statement.setString(5, etc);

					statement.executeUpdate();

					ret = true;
				}
			}

			catch (Exception e) {
				System.out.println("Exception " + e.getMessage());
				e.printStackTrace();
			} finally {
				try {

					if (null != connection)
						connection.close();
					if (null != statement)
						statement.close();
					if (null != resultSet)
						resultSet.close();

				} catch (SQLException sqlException) {

				}

			}

		} catch (Exception e) {
			logger.error("AccidentDaoImplement : " + e.toString());
			throw e;
		}

		return ret;
	}

}
