package com.cpted.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.cpted.base.BaseDaoImplement;
import com.cpted.beans.AccidentBean;
import com.cpted.beans.AccidentEmergency;
import com.cpted.beans.MemberBean;
import com.cpted.beans.MemberCrimeWatch;

public class MemberDaoImplement extends BaseDaoImplement implements MemberDao {
//
//	Connection connection = null;
//	String sql = "";
//	
//		
////	
////	public boolean IsInBoundary(MemberBean user, String longtitude, String latitude)
////	{
////		
////		boolean ret = false;
////		
////		(longtitude - user.get)
////		
////		
////		
////		
////		
////		
////		
////		return ret;
////	
////	}
//	
//	public List GetNearCrimeWatchMembers(String longtitude, String latitude)
//			throws Exception {
//		// TODO Auto-generated method stub
//		try {
//
//			PreparedStatement statement = null;
//			ResultSet resultSet = null;
//						
//			ArrayList watchMemberList = new ArrayList();
//			
//			//위치를 주면, 위치의 + 100 인 지역에 있는 타입이 2인 사람 
//			sql = "select * from user where type=2";
//			try {
//
//				Class.forName("com.mysql.jdbc.Driver");
//
//				connection = DriverManager.getConnection(
//						"jdbc:mysql://localhost:3306/cpteddb", "root",
//						"gpem4162");
//				if (connection != null) {
//
//					statement = connection.prepareStatement(sql);
//					resultSet = statement.executeQuery();
//					while (resultSet.next()) {
//						MemberCrimeWatch memberCrimeWatch = new MemberCrimeWatch();
//
//						memberCrimeWatch.setID(resultSet
//								.getString("user_idx"));
//						memberCrimeWatch.setCategorize(resultSet
//								.getString("type"));
//						memberCrimeWatch.setGcm(resultSet
//								.getString("gcm"));
//						memberCrimeWatch.setPhone(Integer.parseInt((resultSet.getString("phone"))));
//						memberCrimeWatch.setAge(Integer.parseInt((resultSet.getString("age"))));
//						memberCrimeWatch.setGender(Integer.parseInt((resultSet.getString("gender"))));
//								
//						memberCrimeWatch.setEtc(resultSet
//								.getString("ect"));
//						watchMemberList.add(memberCrimeWatch);
//
//					}
//				}
//
//			}
//
//			catch (Exception e) {
//				System.out.println("Exception " + e.getMessage());
//				e.printStackTrace();
//			} finally {
//				try {
//
//					if (null != connection)
//						connection.close();
//					if (null != statement)
//						statement.close();
//					if (null != resultSet)
//						resultSet.close();
//
//				} catch (SQLException sqlException) {
//
//				}
//			}
//			watchMemberList.
//						
//			return accidentEmergencyList;
//
//		}
//
//		catch (Exception e) {
//			logger.error("AccidentDaoImplement : " + e.toString());
//			throw e;
//		}
//
//	}
}
