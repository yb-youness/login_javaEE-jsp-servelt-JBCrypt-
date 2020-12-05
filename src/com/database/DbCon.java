package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {
  private static String JDBC_URL="jdbc:mysql://localhost:3306/login";
  private static String NAME="root";
  private static String PASS="";
  
  public static Connection Con() {
	  Connection con=null;
	  try {
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  con= DriverManager.getConnection(JDBC_URL,NAME,PASS);
	  }catch(ClassNotFoundException e) {
		  e.printStackTrace();
	  }catch(SQLException e) {
		  e.printStackTrace();
	  }
	  return con;
  }
}
