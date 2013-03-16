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

	// 일반신고 add

	public boolean AddAccidentGeneral(AccidentGeneral accidentGeneral) throws Exception {
		boolean ret = false;

		// TODO Auto-generated method stub
		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;
			
			sql = "insert into report(datetime,type,longtitude,latitude,image,content,degree,checked,user_idx) values (?,?,?,?,?,?,?,?,?)";
			
			try {

				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cpteddb", "root",
						"gpem4162");
				if (connection != null) {

					
					statement = connection.prepareStatement(sql);
					statement.setString(1, accidentGeneral.getDate());
					statement.setString(2, accidentGeneral.getCategorize());
					statement.setString(3, (accidentGeneral.getLongtitude()));
					statement.setString(4, (accidentGeneral.getLatitude()));
					statement.setString(5, accidentGeneral.getPhoto());
					statement.setString(6, accidentGeneral.getContent());
					statement.setString(7, accidentGeneral.getDegree());
					statement.setString(8, Integer.toString(accidentGeneral.getChecked()));
					statement.setString(9, accidentGeneral.getUserid());
					
										
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
		}

		catch (Exception e) {
			logger.error("AccidentDaoImplement : " + e.toString());
			throw e;
		}

		return ret;
	}

	// AccidentEmergency list
	public List<AccidentEmergency> LoadAccidentEmegencyCurrent()
			throws Exception {
		// TODO Auto-generated method stub
		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;
			ArrayList<AccidentEmergency> accidentEmergencyList = new ArrayList<AccidentEmergency>();

			sql = "select * from report, chargedarea where report.type=2 and "
					+ "report.checked=0 and " + "chargedarea.center_idx = ? "
					+ "and chargedarea.checked = 1 and "
					+ "report.longtitude < chargedarea.right and "
					+ "report.longtitude > chargedarea.left and "
					+ "report.latitude < chargedarea.top and "
					+ "report.latitude > chargedarea.bottom";
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
						AccidentEmergency accidentEmergency = new AccidentEmergency();

//						accidentEmergency.setID(resultSet
//								.getString("report_idx"));
						accidentEmergency.setDate(resultSet
								.getString("datetime"));
						accidentEmergency.setCategorize(resultSet
								.getString("type"));
						accidentEmergency.setLatitude((resultSet
								.getString("latitude")));
						accidentEmergency.setLongtitude((resultSet
								.getString("longtitude")));
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
			sql = "select * from report, chargedarea where report.type=1 and "
					+ "report.checked=0 and " + "chargedarea.center_idx = ? "
					+ "and chargedarea.checked = 1 and "
					+ "report.longtitude < chargedarea.right and "
					+ "report.longtitude > chargedarea.left and "
					+ "report.latitude < chargedarea.top and "
					+ "report.latitude > chargedarea.bottom";

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
						AccidentGeneral accidentGeneral = new AccidentGeneral();

//						accidentGeneral
//								.setID(resultSet.getString("report_idx"));
						accidentGeneral
								.setDate(resultSet.getString("datetime"));
						accidentGeneral.setCategorize(resultSet
								.getString("type"));
						accidentGeneral.setLatitude((resultSet
								.getString("latitude")));
						accidentGeneral.setLongtitude((resultSet
								.getString("longtitude")));
						accidentGeneral.setPhoto(resultSet.getString("image"));
						accidentGeneral.setContent(resultSet
								.getString("content"));
						// accidentGeneral
						// .setDegree(resultSet.getString("degree"));
						//
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

	// 위험구역
	// AccidentShare list

	// 접수처리여부 (check로하는것이 아니라) degree에 따라 달라진다.
	public List<AccidentShare> LoadAccidentShareCurrent() throws Exception {
		// TODO Auto-generated method stub

		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;
			ArrayList<AccidentShare> accidentShareList = new ArrayList<AccidentShare>();

			sql = "select * from report, chargedarea where report.type=0 and "
					+ "report.checked=0 and " + "chargedarea.center_idx = ? "
					+ "and chargedarea.checked = 1 and "
					+ "report.longtitude < chargedarea.right and "
					+ "report.longtitude > chargedarea.left and "
					+ "report.latitude < chargedarea.top and "
					+ "report.latitude > chargedarea.bottom";

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
						AccidentShare accidentShare = new AccidentShare();

//						accidentShare.setID(resultSet.getString("report_idx"));
						accidentShare.setDate(resultSet.getString("datetime"));
						accidentShare
								.setCategorize(resultSet.getString("type"));
						accidentShare.setLatitude((resultSet
								.getString("latitude")));
						accidentShare.setLongtitude((resultSet
								.getString("longtitude")));
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

	// 화면에 표시되는 위험 구역
	// AccidentShare list

	// 접수처리여부 (check로하는것이 아니라) degree에 따라 달라진다.
	public List<AccidentShare> LoadAccidentShareCurrentLocations(String top,
			String left, String right, String bottom) throws Exception {
		// TODO Auto-generated method stub

		try {

			PreparedStatement statement = null;
			ResultSet resultSet = null;
			ArrayList<AccidentShare> accidentShareList = new ArrayList<AccidentShare>();

			sql = "select * from report r, chargedarea c "
					+ "where r.type=0 and r.checked=0 and "
					+ "r.longtitude < ? and " + "r.longtitude > ? and "
					+ "r.latitude < ? and " + "r.latitude > ? and "
					+ "r.longtitude < c.right and "
					+ "r.longtitude > c.left and " + "r.latitude < c.top and "
					+ "r.latitude > c.bottom";
			try {

				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cpteddb", "root",
						"gpem4162");
				if (connection != null) {

					statement = connection.prepareStatement(sql);
					statement.setString(1, right);
					statement.setString(2, left);
					statement.setString(3, top);
					statement.setString(4, bottom);
					// // statement.setString(5, /*center_id*/);
					resultSet = statement.executeQuery();
					while (resultSet.next()) {
						AccidentShare accidentShare = new AccidentShare();

//						accidentShare.setID(resultSet.getString("report_idx"));
						accidentShare.setDate(resultSet.getString("datetime"));
						accidentShare
								.setCategorize(resultSet.getString("type"));
						accidentShare.setLatitude((resultSet
								.getString("latitude")));
						accidentShare.setLongtitude((resultSet
								.getString("longtitude")));
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

			sql = "select * from report, chargedarea where "
					+ "report.checked=0 and " + "chargedarea.center_idx = ? "
					+ "and chargedarea.checked = 1 and "
					+ "report.longtitude < chargedarea.right and "
					+ "report.longtitude > chargedarea.left and "
					+ "report.latitude < chargedarea.top and "
					+ "report.latitude > chargedarea.bottom";

			try {

				Class.forName("com.mysql.jdbc.Driver");
				// Establish the connection.
				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cpteddb", "root",
						"gpem4162");
				if (connection != null) {
					// Use the connection to create the SQL statement.
					statement = connection.prepareStatement(sql);
					// // statement.setString(1, /*center_id*/);
					resultSet = statement.executeQuery();
					while (resultSet.next()) {

						switch (Integer.parseInt(resultSet.getString("type"))) {
						case 0:
							AccidentShare accidentShare = new AccidentShare();

//							accidentShare.setID(resultSet
//									.getString("report_idx"));
							accidentShare.setDate(resultSet
									.getString("datetime"));
							accidentShare.setCategorize(resultSet
									.getString("type"));
							accidentShare.setLatitude((resultSet
									.getString("latitude")));
							accidentShare.setLongtitude((resultSet
									.getString("longtitude")));
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

//							accidentGeneral.setID(resultSet
//									.getString("report_idx"));
							accidentGeneral.setDate(resultSet
									.getString("datetime"));
							accidentGeneral.setCategorize(resultSet
									.getString("type"));
							accidentGeneral.setLatitude((resultSet
									.getString("latitude")));
							accidentGeneral.setLongtitude((resultSet
									.getString("longtitude")));
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

//							accidentEmergency.setID(resultSet
//									.getString("report_idx"));
							accidentEmergency.setDate(resultSet
									.getString("datetime"));
							accidentEmergency.setCategorize(resultSet
									.getString("type"));
							accidentEmergency.setLatitude((resultSet
									.getString("latitude")));
							accidentEmergency.setLongtitude((resultSet
									.getString("longtitude")));
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

			// AccidentBean a = (AccidentBean)accidentAllList.get(0);
			// String sdf = a.getLongtitude();
			return accidentAllList;

		} catch (Exception e) {
			logger.error("AccidentDaoImplement : " + e.toString());
			throw e;
		}

	}

}
