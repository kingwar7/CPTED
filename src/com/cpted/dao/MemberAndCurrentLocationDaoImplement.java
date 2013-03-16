package com.cpted.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cpted.base.BaseDaoImplement;
import com.cpted.beans.MemberCrimeWatch;
import com.cpted.beans.MemberGeneralUser;
import com.cpted.beans.MemberPolice;

public class MemberAndCurrentLocationDaoImplement extends BaseDaoImplement
		implements MemberDao {

	Connection connection = null;
	String sql = "";

	// 방범대를 선택하고 전송을 눌렀을 때 보내 보내지는 사람들 리스트
	public ArrayList<MemberCrimeWatch> GetNearCrimeWatchMembers(
			String longtitude, String latitude) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<MemberCrimeWatch> watchMemberList = new ArrayList<MemberCrimeWatch>();
		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;

			int distance = 1000;

			// 위치를 주면, 위치의 + 100 인 지역에 있는 타입이 2인 사람
			sql = "select * from user , chargedarea join currentLocation on user.uesr_idx = currentLocation.user_idx " +
					"where user.type=2 and currentLocation.longtitude < ? and " +
					"currentLocation.longtitude > ? and " +
					"currentLocation.latitude < ? and " +
					"currentLocation.latitude > ? and " +
					"chargedarea.center_idx = ? and " +
					"chargedarea.checked = 1 and " +
					"currentLocation.longtitude < chargedarea.left and " +
					"currentLocation.longtitude > chargedarea.right and " +
					"currentLocation.latitude < chargedarea.top and " +
					"currentLocation.latitude > chargedarea.bottom ";
			try {

				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cpteddb", "root",
						"gpem4162");
				if (connection != null) {

					statement = connection.prepareStatement(sql);
					statement.setString(
							1,
							Integer.toString(Integer.parseInt(longtitude)
									+ distance));
					statement.setString(
							2,
							Integer.toString(Integer.parseInt(longtitude)
									- distance));
					statement.setString(
							3,
							Integer.toString(Integer.parseInt(latitude)
									+ distance));
					statement.setString(
							4,
							Integer.toString(Integer.parseInt(latitude)
									- distance));
////					statement.setString(5, /*logined center_id*/);
					resultSet = statement.executeQuery();
					while (resultSet.next()) {
						MemberCrimeWatch memberCrimeWatch = new MemberCrimeWatch();

						memberCrimeWatch.setID(resultSet.getString("user_idx"));
						memberCrimeWatch.setCategorize(resultSet
								.getString("type"));
						memberCrimeWatch.setGcm(resultSet.getString("gcm"));
						memberCrimeWatch.setPhone(Integer.parseInt((resultSet
								.getString("phone"))));
						memberCrimeWatch.setAge(Integer.parseInt((resultSet
								.getString("age"))));
						memberCrimeWatch.setGender(Integer.parseInt((resultSet
								.getString("gender"))));

						memberCrimeWatch.setEtc(resultSet.getString("ect"));
						watchMemberList.add(memberCrimeWatch);

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

		}

		catch (Exception e) {
			logger.error("AccidentDaoImplement : " + e.toString());
			throw e;
		}
		return watchMemberList;
	}

	// 일반사용자를 선택하고 전송을 눌렀을 때 보내 보내지는 사람들 리스트
	public ArrayList<MemberGeneralUser> GetNearGeneralUserMembers(
			String longtitude, String latitude) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<MemberGeneralUser> generalMemberList = new ArrayList<MemberGeneralUser>();
		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;

			int distance = 1000;

			// 위치를 주면, 위치의 + 100 인 지역에 있는 타입이 2인 사람
			sql = "select * from user , chargedarea join currentLocation on user.uesr_idx = currentLocation.user_idx " +
					"where user.type=1 and " +
					"currentLocation.longtitude < ? and " +
					"currentLocation.longtitude > ? and " +
					"currentLocation.latitude < ? and " +
					"currentLocation.latitude > ? and " +
					"chargedarea.center_idx = ? and " +
					"chargedarea.checked = 1 and " +
					"currentLocation.longtitude < chargedarea.left and " +
					"currentLocation.longtitude > chargedarea.right and " +
					"currentLocation.latitude < chargedarea.top and " +
					"currentLocation.latitude > chargedarea.bottom ";
			try {

				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cpteddb", "root",
						"gpem4162");
				if (connection != null) {

					statement = connection.prepareStatement(sql);
					statement.setString(
							1,
							Integer.toString(Integer.parseInt(longtitude)
									+ distance));
					statement.setString(
							2,
							Integer.toString(Integer.parseInt(longtitude)
									- distance));
					statement.setString(
							3,
							Integer.toString(Integer.parseInt(latitude)
									+ distance));
					statement.setString(
							4,
							Integer.toString(Integer.parseInt(latitude)
									- distance));
////					statement.setString(5, /*logined center_id*/);
					resultSet = statement.executeQuery();
					while (resultSet.next()) {
						MemberGeneralUser memberGeneralUser = new MemberGeneralUser();

						memberGeneralUser
								.setID(resultSet.getString("user_idx"));
						memberGeneralUser.setCategorize(resultSet
								.getString("type"));
						memberGeneralUser.setGcm(resultSet.getString("gcm"));
						memberGeneralUser.setPhone(Integer.parseInt((resultSet
								.getString("phone"))));
						memberGeneralUser.setAge(Integer.parseInt((resultSet
								.getString("age"))));
						memberGeneralUser.setGender(Integer.parseInt((resultSet
								.getString("gender"))));

						memberGeneralUser.setEtc(resultSet.getString("ect"));
						generalMemberList.add(memberGeneralUser);

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

		}

		catch (Exception e) {
			logger.error("AccidentDaoImplement : " + e.toString());
			throw e;
		}
		return generalMemberList;
	}

	// 경찰및 공무원 을 선택하고 전송을 눌렀을 때 보내 보내지는 사람들 리스트
	public ArrayList<MemberPolice> GetNearPoliceMembers(String longtitude,
			String latitude) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<MemberPolice> policeMemberList = new ArrayList<MemberPolice>();
		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;

			int distance = 1000;

			// 위치를 주면, 위치의 + 100 인 지역에 있는 타입이 2인 사람
			sql = "select * from user  , chargedarea join currentLocation on user.uesr_idx = currentLocation.user_idx " +
					"where user.type=3 and " +
					"currentLocation.longtitude < ? and " +
					"currentLocation.longtitude > ? and " +
					"currentLocation.latitude < ? and " +
					"currentLocation.latitude > ? and " +
					"chargedarea.center_idx = ? and " +
					"chargedarea.checked = 1 and " +
					"currentLocation.longtitude < chargedarea.left and " +
					"currentLocation.longtitude > chargedarea.right and " +
					"currentLocation.latitude < chargedarea.top and " +
					"currentLocation.latitude > chargedarea.bottom ";
			try {

				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cpteddb", "root",
						"gpem4162");
				if (connection != null) {

					statement = connection.prepareStatement(sql);
					statement.setString(
							1,
							Integer.toString(Integer.parseInt(longtitude)
									+ distance));
					statement.setString(
							2,
							Integer.toString(Integer.parseInt(longtitude)
									- distance));
					statement.setString(
							3,
							Integer.toString(Integer.parseInt(latitude)
									+ distance));
					statement.setString(
							4,
							Integer.toString(Integer.parseInt(latitude)
									- distance));
////					statement.setString(5, /*logined center_id*/);
					resultSet = statement.executeQuery();
					while (resultSet.next()) {
						MemberPolice memberPolice = new MemberPolice();

						memberPolice.setID(resultSet.getString("user_idx"));
						memberPolice.setCategorize(resultSet.getString("type"));
						memberPolice.setGcm(resultSet.getString("gcm"));
						memberPolice.setPhone(Integer.parseInt((resultSet
								.getString("phone"))));
						memberPolice.setAge(Integer.parseInt((resultSet
								.getString("age"))));
						memberPolice.setGender(Integer.parseInt((resultSet
								.getString("gender"))));

						memberPolice.setEtc(resultSet.getString("ect"));
						policeMemberList.add(memberPolice);

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

		}

		catch (Exception e) {
			logger.error("AccidentDaoImplement : " + e.toString());
			throw e;
		}
		return policeMemberList;
	}

	// 방범대를 선택한 상태의 화면에 보이는 방범대원 리스트
	public ArrayList<MemberCrimeWatch> GetCrimeWathMembersInView(String top, String left,
			String right, String bottom) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<MemberCrimeWatch> MemberList = new ArrayList<MemberCrimeWatch>();
		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;

			// 위치를 주면, 위치의 + 100 인 지역에 있는 타입이 2인 사람
			sql = "select * from user , chargedarea join currentLocation on user.uesr_idx = currentLocation.user_idx " +
					"where user.type=2 and " +
					"currentLocation.longtitude < ? and " +
					"currentLocation.longtitude > ? and " +
					"currentLocation.latitude < ? and " +
					"currentLocation.latitude > ? and " +
					"chargedarea.center_idx = ? and " +
					"chargedarea.checked = 1 and " +
					"currentLocation.longtitude < chargedarea.left and " +
					"currentLocation.longtitude > chargedarea.right and " +
					"currentLocation.latitude < chargedarea.top and " +
					"currentLocation.latitude > chargedarea.bottom ";
			try {

				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cpteddb", "root",
						"gpem4162");
				if (connection != null) {

					statement = connection.prepareStatement(sql);
					statement.setString(1,
							Integer.toString(Integer.parseInt(right)));
					statement.setString(2,
							Integer.toString(Integer.parseInt(left)));
					statement.setString(3,
							Integer.toString(Integer.parseInt(top)));
					statement.setString(4,
							Integer.toString(Integer.parseInt(bottom)));
////					statement.setString(5, /*logined center_id*/);
					resultSet = statement.executeQuery();
					while (resultSet.next()) {

						MemberCrimeWatch memberCrimeWatch = new MemberCrimeWatch();

						memberCrimeWatch.setID(resultSet.getString("user_idx"));
						memberCrimeWatch.setCategorize(resultSet
								.getString("type"));
						memberCrimeWatch.setGcm(resultSet.getString("gcm"));
						memberCrimeWatch.setPhone(Integer.parseInt((resultSet
								.getString("phone"))));
						memberCrimeWatch.setAge(Integer.parseInt((resultSet
								.getString("age"))));
						memberCrimeWatch.setGender(Integer.parseInt((resultSet
								.getString("gender"))));

						memberCrimeWatch.setEtc(resultSet.getString("ect"));
						MemberList.add(memberCrimeWatch);

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

		}

		catch (Exception e) {
			logger.error("AccidentDaoImplement : " + e.toString());
			throw e;
		}
		return MemberList;
	}

	// 일반사용자를 선택한 상태의 화면에 보이는 방범대원 리스트
	public ArrayList<MemberGeneralUser> GetGeneralUserMembersInView(String top, String left,
			String right, String bottom) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<MemberGeneralUser> MemberList = new ArrayList<MemberGeneralUser>();
		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;

			// 위치를 주면, 위치의 + 100 인 지역에 있는 타입이 2인 사람
			sql = "select * from user , chargedarea join currentLocation on user.uesr_idx = currentLocation.user_idx " +
					"where user.type=2 and " +
					"currentLocation.longtitude < ? and " +
					"currentLocation.longtitude > ? and " +
					"currentLocation.latitude < ? and " +
					"currentLocation.latitude > ? and " +
					"chargedarea.center_idx = ? and " +
					"chargedarea.checked = 1 and " +
					"currentLocation.longtitude < chargedarea.left and " +
					"currentLocation.longtitude > chargedarea.right and " +
					"currentLocation.latitude < chargedarea.top and " +
					"currentLocation.latitude > chargedarea.bottom ";
			try {

				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cpteddb", "root",
						"gpem4162");
				if (connection != null) {

					statement = connection.prepareStatement(sql);
					statement.setString(1,
							Integer.toString(Integer.parseInt(right)));
					statement.setString(2,
							Integer.toString(Integer.parseInt(left)));
					statement.setString(3,
							Integer.toString(Integer.parseInt(top)));
					statement.setString(4,
							Integer.toString(Integer.parseInt(bottom)));
	////				statement.setString(5, /*logined center_id*/);
					resultSet = statement.executeQuery();
					while (resultSet.next()) {

						MemberGeneralUser memberGeneralUser = new MemberGeneralUser();

						memberGeneralUser
								.setID(resultSet.getString("user_idx"));
						memberGeneralUser.setCategorize(resultSet
								.getString("type"));
						memberGeneralUser.setGcm(resultSet.getString("gcm"));
						memberGeneralUser.setPhone(Integer.parseInt((resultSet
								.getString("phone"))));
						memberGeneralUser.setAge(Integer.parseInt((resultSet
								.getString("age"))));
						memberGeneralUser.setGender(Integer.parseInt((resultSet
								.getString("gender"))));

						memberGeneralUser.setEtc(resultSet.getString("ect"));
						MemberList.add(memberGeneralUser);

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

		}

		catch (Exception e) {
			logger.error("AccidentDaoImplement : " + e.toString());
			throw e;
		}
		return MemberList;
	}

	// 방범대를 선택한 상태의 화면에 보이는 방범대원 리스트
	public ArrayList<MemberPolice> GetPoliceMembersInView(String top, String left,
			String right, String bottom) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<MemberPolice> MemberList = new ArrayList<MemberPolice>();
		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;

			// 위치를 주면, 위치의 + 100 인 지역에 있는 타입이 2인 사람
			sql = "select * from user join currentLocation on user.uesr_idx = currentLocation= user_idx where user.type=2 and currentLocation.longtitude < ? and currentLocation.longtitude > ? and currentLocation.latitude < ? and currentLocation.latitude > ?";
			try {

				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cpteddb", "root",
						"gpem4162");
				if (connection != null) {

					statement = connection.prepareStatement(sql);
					statement.setString(1,
							Integer.toString(Integer.parseInt(right)));
					statement.setString(2,
							Integer.toString(Integer.parseInt(left)));
					statement.setString(3,
							Integer.toString(Integer.parseInt(top)));
					statement.setString(4,
							Integer.toString(Integer.parseInt(bottom)));
////					statement.setString(5, /*logined center_id*/);
					resultSet = statement.executeQuery();
					while (resultSet.next()) {

						MemberPolice memberPolice = new MemberPolice();

						memberPolice.setID(resultSet.getString("user_idx"));
						memberPolice.setCategorize(resultSet.getString("type"));
						memberPolice.setGcm(resultSet.getString("gcm"));
						memberPolice.setPhone(Integer.parseInt((resultSet
								.getString("phone"))));
						memberPolice.setAge(Integer.parseInt((resultSet
								.getString("age"))));
						memberPolice.setGender(Integer.parseInt((resultSet
								 .getString("gender"))));

						memberPolice.setEtc(resultSet.getString("ect"));
						MemberList.add(memberPolice);

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

		}

		catch (Exception e) {
			logger.error("AccidentDaoImplement : " + e.toString());
			throw e;
		}
		return MemberList;
	}
}
