package com.cpted.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cpted.base.BaseDaoImplement;

public class CentercodeDaoImplement extends BaseDaoImplement implements
		CentercodeDao {

	Connection connection = null;
	String sql = "";

	// 기관 인증 코드 식별
	public boolean CheckOrganizationAuthCode(String code) throws Exception {
		// TODO Auto-generated method stub
		boolean ret = false;
		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;

			sql = "select * from centercodetable where code = ?";
			try {

				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cpteddb", "root",
						"gpem4162");
				if (connection != null) {

					statement = connection.prepareStatement(sql);

					statement.setString(1, code);

					resultSet = statement.executeQuery();

					if (resultSet.next()) {

						// 코드 인증
						resultSet.close();
						ret = true;

					} else {

						resultSet.close();
						// 코드 인증 안됨
						ret = false;
					}

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
