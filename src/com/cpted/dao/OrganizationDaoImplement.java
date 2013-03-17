package com.cpted.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cpted.base.BaseDaoImplement;
import com.cpted.beans.ChargedAreaBean;
import com.cpted.beans.OrganizationBean;

public class OrganizationDaoImplement extends BaseDaoImplement implements
		OrganizationDao {

	String connectionString =
			"jdbc:sqlserver://ihzwa48g5r.database.windows.net:1433;" +
			"database=cptedsqldb;" +
			"user=dean4208@ihzwa48g5r;" +
			"password=gpem4162!;encrypt=true;" +
			"hostNameInCertificate=*.database.windows.net;" +
			"loginTimeout=30";
	
	Connection connection = null;
	String sql = "";

	// 회원가입

	// public boolean SignUp(String id, String password, String name, String
	// code, String etc) throws Exception {
	public boolean SignUp(OrganizationBean organization) throws Exception {
		// TODO Auto-generated method stub
		boolean ret = false;
		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;
			sql = "INSERT INTO center(id,password,name,code,etc) values(?,?,?,?,?)";
			try {

//				Class.forName("com.mysql.jdbc.Driver");
//
//				connection = DriverManager.getConnection(
//						"jdbc:mysql://localhost:3306/cpteddb", "root",
//						"gpem4162");
				
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection = DriverManager.getConnection(connectionString);
				
				if (connection != null) {

					statement = connection.prepareStatement(sql);

					statement.setString(1, organization.getID());
					statement.setString(2, organization.getPw());
					statement.setString(3, organization.getName());
					statement.setString(4, organization.getCode());
					statement.setString(5, organization.getEtc());

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

	// 로그인 id,pw검사
	public boolean checkLogin(String id, String password) throws Exception {
		// TODO Auto-generated method stub
		boolean ret = false;
		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;
			sql = "SELECT * FROM center WHERE id =? and password =? ";
			try {

//				Class.forName("com.mysql.jdbc.Driver");
//
//				connection = DriverManager.getConnection(
//						"jdbc:mysql://localhost:3306/cpteddb", "root",
//						"gpem4162");
//				
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection = DriverManager.getConnection(connectionString);
				
				if (connection != null) {

					statement = connection.prepareStatement(sql);

					statement.setString(1, id);
					statement.setString(2, password);

					resultSet = statement.executeQuery();

					if (resultSet.next()) {
						ret = true;
						statement.close();
						return true;
						// 로그인성공
					} else {
						ret = false;
						statement.close();
						return false;
						// 로그인 실패
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

	// 아이디 중복
	// 중복이면 True 출력
	public boolean idDuplicate(OrganizationBean organization) throws Exception {
		// TODO Auto-generated method stub
		boolean ret = false;
		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;
			sql = "select * from center where id =?";
			try {

//				Class.forName("com.mysql.jdbc.Driver");
//
//				connection = DriverManager.getConnection(
//						"jdbc:mysql://localhost:3306/cpteddb", "root",
//						"gpem4162");
				
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection = DriverManager.getConnection(connectionString);
				
				
				if (connection != null) {

					statement = connection.prepareStatement(sql);

					statement.setString(1, organization.getID());

					resultSet = statement.executeQuery();

					if (resultSet.next()) {
						ret = true;
						statement.close();
						return true;
						// 로그인성공
					} else {
						ret = false;
						statement.close();
						return false;
						// 로그인 실패
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

	// 회원정보 수정
	// code는 바꿀 수 없다.
	public boolean updateOrganization(OrganizationBean organization)
			throws Exception {
		// TODO Auto-generated method stub
		boolean ret = false;
		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;
			sql = "update center set password =?  name= ?, etc = ? where id = ?";
			try {

//				Class.forName("com.mysql.jdbc.Driver");
//
//				connection = DriverManager.getConnection(
//						"jdbc:mysql://localhost:3306/cpteddb", "root",
//						"gpem4162");
				
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection = DriverManager.getConnection(connectionString);
				
				
				if (connection != null) {

					statement = connection.prepareStatement(sql);

					statement.setString(1, organization.getPw());
					statement.setString(2, organization.getName());
					statement.setString(3, organization.getEtc());
					statement.setString(1, organization.getID());

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

	// 회원정보 삭제
	// code는 바꿀 수 없다.
	public boolean deleteOrganization(OrganizationBean organization)
			throws Exception {
		// TODO Auto-generated method stub
		boolean ret = false;
		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;
			sql = "delete from center where id = ?";
			try {

//				Class.forName("com.mysql.jdbc.Driver");
//
//				connection = DriverManager.getConnection(
//						"jdbc:mysql://localhost:3306/cpteddb", "root",
//						"gpem4162");
				
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection = DriverManager.getConnection(connectionString);
				
				if (connection != null) {

					statement = connection.prepareStatement(sql);

					statement.setString(1, organization.getID());

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
	
	
	
	//get center_idx 고유 id
	
	
	public String getCenterIDx(String id, String password)throws Exception {
		String centerIDx = "";
		try {
			
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			sql = "select * from center where id = ? and password = ?";
			try {

//				Class.forName("com.mysql.jdbc.Driver");
//
//				connection = DriverManager.getConnection(
//						"jdbc:mysql://localhost:3306/cpteddb", "root",
//						"gpem4162");
				
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection = DriverManager.getConnection(connectionString);
				
				if (connection != null) {

					statement = connection.prepareStatement(sql);
					
					statement.setString(1, id);
					statement.setString(2, password);
					resultSet = statement.executeQuery();
					if(resultSet.next())
					{
					centerIDx = resultSet.getString("center_idx");
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

		return centerIDx;
		
		
	}

}
