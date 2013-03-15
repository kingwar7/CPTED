package com.cpted.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cpted.base.BaseDaoImplement;
import com.cpted.beans.LocationBean;
import com.cpted.beans.MemberBean;
import com.cpted.beans.MemberCrimeWatch;

public class LocationDaoImplement extends BaseDaoImplement implements LocationDao {

	Connection connection = null;
	String sql = "";

	public LocationBean GetLocation(MemberBean user)
			throws Exception {
		// TODO Auto-generated method stub
		LocationBean location = new LocationBean();	
		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;
			
			
			sql = "select * from Location where user_idx = ? limit 1 order by location_idx";
			try {

				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cpteddb", "root",
						"gpem4162");
				if (connection != null) {

					statement = connection.prepareStatement(sql);
					
					statement.setString(1, user.getID());
					
					
					resultSet = statement.executeQuery();
			
					location.setID(resultSet
								.getString("location_idx"));
					location.setUserID(resultSet
								.getString("user_idx"));
					
					location.setLongtitude(resultSet
								.getString("longtitude"));
					location.setLatitude((resultSet.getString("latitude")));
					
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

		}

		catch (Exception e) {
			logger.error("AccidentDaoImplement : " + e.toString());
			throw e;
		}
		
		
		return location;
	}
}
