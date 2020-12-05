package com.model;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
	 private String name;
	 private String email;
	 private String password;
	  
	public User() {
		super();
	}

	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 
	public HashMap<String, String> validatelogin (){
		
		HashMap<String, String> msg = new HashMap<String, String>();
		 if(email.isEmpty()|| name.isEmpty()) {
			  msg.put("login","login must not be empty");
		 }if(password.isEmpty()) {
			 msg.put("pass","Password  must not be empty");
		 }
		 if(!email.isEmpty()) {
			 String regex = "^(.+)@(.+)$";
			 Pattern pattern = Pattern.compile(regex);
			 Matcher matcher = pattern.matcher(email);
			  if(!matcher.matches()) {
				  msg.put("login","Email is not in valid format ");
			  }   
		 }
		return msg;
	}
	
	public HashMap<String, String> validateRegiste (String name,String email,String pass,String confpass){
		
		HashMap<String, String> msg = new HashMap<String, String>();
		
		  //Validate Login
			 if(name.isEmpty()) {
				  msg.put("name","Name must not be empty !!");
			 }
			 if(!name.isEmpty()) {
				  if(name.length()<6) {
					  msg.put("name","Name must contain at least 6 characters !!");
				  }   
			 }
		
	  //Validate Email
		 if(email.isEmpty()) {
			  msg.put("email","Email must not be empty");
		 }
		 if(!email.isEmpty()) {
			 String regex = "^(.+)@(.+)$";
			 Pattern pattern = Pattern.compile(regex);
			 Matcher matcher = pattern.matcher(email);
			  if(!matcher.matches()) {
				  msg.put("email","Email is not in valid format !! ");
			  }   
		 }
		 // Validate Password
		if(password.isEmpty()) {
			 msg.put("pass","Password  must not be empty");
		 } if(confpass.isEmpty()) {
			 msg.put("confpass","Confirm Password  must not be empty !!");
		 }if(!password.isEmpty()) {
			 String regex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
			 Pattern pattern = Pattern.compile(regex);
			 Matcher matcher = pattern.matcher(password);
			  if(!matcher.matches()) {
				  msg.put("pass","Password must contains at least  Minimum eight characters, at least one letter and one number !! ");
			  }   
		 }
		  //Validate Confirm Password
		 if(!confpass.equals(pass)& !confpass.isEmpty()) {
			 msg.put("confpass","Confirm Password  must match the password !!");
		 }
		 
	
		return msg;
	}
}
