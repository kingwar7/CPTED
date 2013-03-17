package com.cpted.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cpted.base.BaseDaoImplement;
import com.cpted.beans.ChargedAreaBean;
import com.cpted.beans.LocationBean;
import com.cpted.beans.MemberBean;
import com.cpted.beans.MemberCrimeWatch;

public class ChargedAreaDaoImplement extends BaseDaoImplement implements
		ChargedAreaDao {
	String connectionString =
			"jdbc:sqlserver://ihzwa48g5r.database.windows.net:1433;" +
			"database=cptedsqldb;" +
			"user=dean4208@ihzwa48g5r;" +
			"password=gpem4162!;encrypt=true;" +
			"hostNameInCertificate=*.database.windows.net;" +
			"loginTimeout=30";
	Connection connection = null;
	String sql = "";

	// 적용된 담당구역 전체 리스트
	public ArrayList<ChargedAreaBean> GetCheckedChagedAreaList()
			throws Exception {
		// TODO Auto-generated method stub

		ArrayList<ChargedAreaBean> chargedAreaList = new ArrayList<ChargedAreaBean>();
		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;

			
			sql = "select * from chagedarea where center_idx = ? and checked = 1";
			try {

				Class.forName("com.mysql.jdbc.Driver");

//				connection = DriverManager.getConnection(
//						"jdbc:mysql://localhost:3306/cpteddb", "root",
//						"gpem4162");
				
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection = DriverManager.getConnection(connectionString);
				
				
				if (connection != null) {

					statement = connection.prepareStatement(sql);

					// // statement.setString(1, /*center_id*/);

					resultSet = statement.executeQuery();

					while (resultSet.next()) {
						ChargedAreaBean chargedArea = new ChargedAreaBean();

						// chargedArea.setID(Integer.parseInt(resultSet.getString("area_idx")));
						chargedArea.setLeft(Double.parseDouble(resultSet
								.getString("left")));
						chargedArea.setRight(Double.parseDouble(resultSet
								.getString("right")));
						chargedArea.setBottom(Double.parseDouble(resultSet
								.getString("bottom")));
						chargedArea.setTop(Double.parseDouble(resultSet
								.getString("top")));
						chargedAreaList.add(chargedArea);
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

		return chargedAreaList;
	}

	// 아이디에 따른 담당구역
	public ChargedAreaBean GetChargedArea(int id) throws Exception {
		// TODO Auto-generated method stub

		ChargedAreaBean chargedArea = new ChargedAreaBean();

		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;

			sql = "select * from chagedarea where chagedarea_id = ? and center_idx = ? ";
			try {

				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cpteddb", "root",
						"gpem4162");
				if (connection != null) {

					statement = connection.prepareStatement(sql);

					statement.setString(1, Integer.toString(id));

					// // statement.setString(2, /*center_id*/);

					resultSet = statement.executeQuery();

					// chargedArea.setID(Integer.parseInt(resultSet.getString("area_idx")));
					chargedArea.setLeft(Double.parseDouble(resultSet
							.getString("left")));
					chargedArea.setRight(Double.parseDouble(resultSet
							.getString("right")));
					chargedArea.setBottom(Double.parseDouble(resultSet
							.getString("bottom")));
					chargedArea.setTop(Double.parseDouble(resultSet
							.getString("top")));

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

		return chargedArea;
	}

	// 로그인된 센터의 담당 구역 리스트 , 리스트에 보여줄 전부
	public ArrayList<ChargedAreaBean> GetAllChagedAreaList() throws Exception {
		// TODO Auto-generated method stub

		ArrayList<ChargedAreaBean> chargedAreaList = new ArrayList<ChargedAreaBean>();
		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;

			sql = "select * from chagedarea where center_idx = ? and checked = 1";
			try {

				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cpteddb", "root",
						"gpem4162");
				if (connection != null) {

					statement = connection.prepareStatement(sql);

					// // statement.setString(1, /*center_id*/);

					resultSet = statement.executeQuery();

					while (resultSet.next()) {
						ChargedAreaBean chargedArea = new ChargedAreaBean();

						// chargedArea.setID(Integer.parseInt(resultSet.getString("area_idx")));
						chargedArea.setLeft(Double.parseDouble(resultSet
								.getString("left")));
						chargedArea.setRight(Double.parseDouble(resultSet
								.getString("right")));
						chargedArea.setBottom(Double.parseDouble(resultSet
								.getString("bottom")));
						chargedArea.setTop(Double.parseDouble(resultSet
								.getString("top")));
						chargedArea.setCheck(Integer.parseInt(resultSet
								.getString("checked")));
						chargedAreaList.add(chargedArea);
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

		return chargedAreaList;
	}

	// 담당 구역 추가
	public void AddChagedArea(String name, String top, String bottom,
			String left, String right) throws Exception {
		// TODO Auto-generated method stub

		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;

			sql = "insert into  chargedarea(name,top,left,right,bottom,checked,center_idx) values(?,?,?,?,?,1,?)";

			try {

				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cpteddb", "root",
						"gpem4162");
				if (connection != null) {

					statement = connection.prepareStatement(sql);

					statement.setString(1, name);

					statement.setString(2, top);

					statement.setString(3, left);

					statement.setString(4, right);

					statement.setString(5, bottom);

					// // statement.setString(6, /*center_id*/);

					statement.executeUpdate();
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

	}

	// 담당구역 수정
	public void ModifyChagedArea(int id, String name, String top,
			String bottom, String left, String right, int checked)
			throws Exception {
		// TODO Auto-generated method stub

		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;

			sql = "update chargedarea set name = ? , top= ?,left =?,right = ?,bottom = ?,checked = ? where area_idx = ?";

			try {

				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cpteddb", "root",
						"gpem4162");
				if (connection != null) {

					statement = connection.prepareStatement(sql);

					statement.setString(1, name);

					statement.setString(2, top);

					statement.setString(3, left);

					statement.setString(4, right);

					statement.setString(5, bottom);

					statement.setString(6, Integer.toString(checked));

					statement.setString(6, Integer.toString(id));

					statement.executeUpdate();
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

	}

	// 담당구역 삭제
	public void RemoveChagedArea(ChargedAreaBean chargedArea) throws Exception {
		// TODO Auto-generated method stub

		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;

			sql = "delete from chargedarea where name = ?";

			try {

				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cpteddb", "root",
						"gpem4162");
				if (connection != null) {

					statement = connection.prepareStatement(sql);

					statement.setString(1, chargedArea.getName());

					statement.executeUpdate();
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

	}
}
