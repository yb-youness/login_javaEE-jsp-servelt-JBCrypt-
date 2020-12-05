package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import com.database.DbCon;
import com.model.User;

public class UserOps  {

	  private static String Insert="INSERT INTO user Values(null,?,?,?,'user')";
	  private static String Verifier= "SELECT COUNT(*),pass FROM user where (email=? or name=?)";
	
	 //Add User Encrypted the pass Word
	
	public static void  AddUser(User user) {
	
		try (Connection con = DbCon.Con()){
			  PreparedStatement stm= con.prepareStatement(Insert);
			  stm.setString(1, user.getName());
			  stm.setString(2, user.getEmail());
			  
			  //Hash  the pass
			  String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			  stm.setString(3, hashed );
			  //////////////////////////////////////
			  stm.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}
		
	}
	
	//Check Credentiale
    public static  boolean CheckUser(String login,String pass) {
    	try(Connection con = DbCon.Con()){
    		  PreparedStatement stm = con.prepareStatement(Verifier);
    		  stm.setString(1, login);
    		  stm.setString(2, login);
    		  
    		
    		  ResultSet rs= stm.executeQuery();
    		  
    		    while(rs.next()) {
    		    	 if(rs.getInt("count(*)")==1) {
    		    		//get the encrypted pass
    		    		 String hashedP=rs.getString("pass");
    		    		 //Check the pass if its valid
    		    		 if (BCrypt.checkpw(pass, hashedP))
    		    				 return true;	
    		    	 }	 
    		    }
    		  
    	}catch(SQLException e) {e.printStackTrace();}
    	
    	return false;
    }


}


