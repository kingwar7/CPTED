package com.cpted.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//import com.microsoft.sqlserver.jdbc.*;
import com.cpted.base.BaseDaoImplement;
import com.cpted.beans.*;

public class AccidentDaoImplement extends BaseDaoImplement implements
		AccidentDao {

	Connection connection = null;
	String sql = "";

	// AccidentEmergency list
	public List<AccidentEmergency> LoadAccidentEmegencyCurrent()
			throws Exception {
		// TODO Auto-generated method stub
		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;
			ArrayList<AccidentEmergency> accidentEmergencyList = new ArrayList<AccidentEmergency>();

			sql = "select * from Report where type=2 and checked=0";
			try {

				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cpteddb", "root",
						"gpem4162");
				if (connection != null) {

					statement = connection.prepareStatement(sql);
					resultSet = statement.executeQuery();
					while (resultSet.next()) {
						AccidentEmergency accidentEmergency = new AccidentEmergency();

						accidentEmergency.setID(resultSet
								.getString("report_idx"));
						accidentEmergency.setDate(resultSet
								.getString("datetime"));
						accidentEmergency.setCategorize(resultSet
								.getString("type"));
						accidentEmergency.setLatitude(resultSet
								.getString("latitude"));
						accidentEmergency.setLongtitude(resultSet
								.getString("longtitude"));
						accidentEmergencyList.add(accidentEmergency);

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
			Collections.sort(accidentEmergencyList,
					new Comparator<AccidentBean>() {
						public int compare(AccidentBean o1, AccidentBean o2) {
							return o1.getDate().compareTo(o2.getDate());
						}
					});
			return accidentEmergencyList;

		}

		catch (Exception e) {
			logger.error("AccidentDaoImplement : " + e.toString());
			throw e;
		}

	}

	// AccidentGeneral list
	public List<AccidentGeneral> LoadAccidentGeneralCurrent() throws Exception {
		// TODO Auto-generated method stub

		try {
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			ArrayList<AccidentGeneral> accidentGeneralList = new ArrayList<AccidentGeneral>();

			sql = "select * from Report where type=1 and checked=0";
			try {

				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cpteddb", "root",
						"gpem4162");
				if (connection != null) {

					statement = connection.prepareStatement(sql);
					resultSet = statement.executeQuery();
					while (resultSet.next()) {
						AccidentGeneral accidentGeneral = new AccidentGeneral();

						accidentGeneral
								.setID(resultSet.getString("report_idx"));
						accidentGeneral
								.setDate(resultSet.getString("datetime"));
						accidentGeneral.setCategorize(resultSet
								.getString("type"));
						accidentGeneral.setLatitude(resultSet
								.getString("latitude"));
						accidentGeneral.setLongtitude(resultSet
								.getString("longtitude"));
						accidentGeneral.setPhoto(resultSet.getString("image"));
						accidentGeneral.setContent(resultSet
								.getString("content"));
						accidentGeneral
								.setDegree(resultSet.getString("degree"));

						accidentGeneralList.add(accidentGeneral);

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
			Collections.sort(accidentGeneralList,
					new Comparator<AccidentBean>() {
						public int compare(AccidentBean o1, AccidentBean o2) {
							return o1.getDate().compareTo(o2.getDate());
						}
					});
			return accidentGeneralList;
		} catch (Exception e) {
			logger.error("AccidentDaoImplement : " + e.toString());
			throw e;
		}

	}

	// AccidentShare list
	public List<AccidentShare> LoadAccidentShareCurrent() throws Exception {
		// TODO Auto-generated method stub

		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;
			ArrayList<AccidentShare> accidentShareList = new ArrayList<AccidentShare>();

			sql = "select * from Report where type=0 and checked=0";
			try {

				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cpteddb", "root",
						"gpem4162");
				if (connection != null) {

					statement = connection.prepareStatement(sql);
					resultSet = statement.executeQuery();
					while (resultSet.next()) {
						AccidentShare accidentShare = new AccidentShare();

						accidentShare.setID(resultSet.getString("report_idx"));
						accidentShare.setDate(resultSet.getString("datetime"));
						accidentShare
								.setCategorize(resultSet.getString("type"));
						accidentShare.setLatitude(resultSet
								.getString("latitude"));
						accidentShare.setLongtitude(resultSet
								.getString("longtitude"));
						accidentShare.setPhoto(resultSet.getString("image"));
						accidentShare
								.setContent(resultSet.getString("content"));
						accidentShare.setDegree(resultSet.getString("degree"));

						accidentShareList.add(accidentShare);

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

			Collections.sort(accidentShareList, new Comparator<AccidentBean>() {
				public int compare(AccidentBean o1, AccidentBean o2) {
					if (o1.getDate() == null || o2.getDate() == null)
						return 0;
					return o1.getDate().compareTo(o2.getDate());
				}
			});

			return accidentShareList;
		} catch (Exception e) {
			logger.error("AccidentDaoImplement : " + e.toString());
			throw e;
		}

	}

	// AccidentAll list(NOT CHECKED)
	// GENERIC ArrayList
	public ArrayList LoadAccidentAllCurrent() throws Exception {
		// TODO Auto-generated method stub

		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;
			ArrayList accidentAllList = new ArrayList();

			sql = "select * from Report where checked=0";
			try {

				Class.forName("com.mysql.jdbc.Driver");
				// Establish the connection.
				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cpteddb", "root",
						"gpem4162");
				if (connection != null) {
					// Use the connection to create the SQL statement.
					statement = connection.prepareStatement(sql);
					resultSet = statement.executeQuery();
					while (resultSet.next()) {

						switch (Integer.parseInt(resultSet.getString("type"))) {
						case 0:
							AccidentShare accidentShare = new AccidentShare();

							accidentShare.setID(resultSet
									.getString("report_idx"));
							accidentShare.setDate(resultSet
									.getString("datetime"));
							accidentShare.setCategorize(resultSet
									.getString("type"));
							accidentShare.setLatitude(resultSet
									.getString("latitude"));
							accidentShare.setLongtitude(resultSet
									.getString("longtitude"));
							accidentShare
									.setPhoto(resultSet.getString("image"));
							accidentShare.setContent(resultSet
									.getString("content"));
							accidentShare.setDegree(resultSet
									.getString("degree"));
							accidentAllList.add(accidentShare);
							break;

						case 1:
							AccidentGeneral accidentGeneral = new AccidentGeneral();

							accidentGeneral.setID(resultSet
									.getString("report_idx"));
							accidentGeneral.setDate(resultSet
									.getString("datetime"));
							accidentGeneral.setCategorize(resultSet
									.getString("type"));
							accidentGeneral.setLatitude(resultSet
									.getString("latitude"));
							accidentGeneral.setLongtitude(resultSet
									.getString("longtitude"));
							accidentGeneral.setPhoto(resultSet
									.getString("image"));
							accidentGeneral.setContent(resultSet
									.getString("content"));
							accidentGeneral.setDegree(resultSet
									.getString("degree"));

							accidentAllList.add(accidentGeneral);

							break;

						case 2:
							AccidentEmergency accidentEmergency = new AccidentEmergency();

							accidentEmergency.setID(resultSet
									.getString("report_idx"));
							accidentEmergency.setDate(resultSet
									.getString("datetime"));
							accidentEmergency.setCategorize(resultSet
									.getString("type"));
							accidentEmergency.setLatitude(resultSet
									.getString("latitude"));
							accidentEmergency.setLongtitude(resultSet
									.getString("longtitude"));
							accidentAllList.add(accidentEmergency);

							break;

						}

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

			Collections.sort(accidentAllList, new Comparator<AccidentBean>() {
				public int compare(AccidentBean o1, AccidentBean o2) {
					return o1.getDate().compareTo(o2.getDate());
				}
			});

			return accidentAllList;

		} catch (Exception e) {
			logger.error("AccidentDaoImplement : " + e.toString());
			throw e;
		}

	}

}
