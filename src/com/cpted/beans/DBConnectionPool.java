package com.cpted.beans;
import java.sql.*;
public class DBConnectionPool {
	 private static DBConnectionPool instance; 

		private String driver="org.gjt.mm.mysql.Driver";
	    private String url="jdbc:mysql://127.0.0.1:8080/projectName?useUnicode=true&useUnicode=true&characterEncoding=utf8";
	    private String user="root";
	    private String password="admin";
	    private Connection conn;
	
		public static synchronized DBConnectionPool getInstance() {
	        if (instance == null) {
			    instance=new DBConnectionPool();
	        }
	        return instance;
	    }

	    private DBConnectionPool() {  
			driverLoading(this.driver,this.url,this.user,this.password);
		}

	
		public Connection getConnetion() throws SQLException{
			conn=DriverManager.getConnection(url,user,password);
			return conn;
		}

	    public void driverLoading(String driver,String url, String user, String password){
	    	System.out.println("driverLoading:"+driver+":"+url+":"+user+":"+password);
			if(driver !=null) this.driver=driver;
			if(url !=null) this.url=url;
			if(user != null) this.user=user;
			if(password != null) this.password=password;
			try{
				Class.forName(driver);
				conn=DriverManager.getConnection(url,user,password);
		    } catch (Exception e){
			    System.out.println("Driver Loading Error  : \n");
				e.printStackTrace();
		    }
	    }
}
