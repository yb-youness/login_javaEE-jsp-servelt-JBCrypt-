package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;
import com.service.UserOps;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	@Override
	public void init() throws ServletException {
		
		super.init();
		
		UserOps userOps ;
	}
	
    public Controller() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getServletPath();
		     switch (action) {
		        
				case "/": //login form
					  ShowForm(request, response, "index");
					break;
				case "/registerform": 
					  ShowForm(request, response, "register");
					break;
				case "/login": //login  Logic
					  Login(request, response);
					break;
				case "/register": //Register logic
					  register(request, response);
					break;
				case "/desconect": //Disconnect + destroy cookies and session
					request.getSession().invalidate();
					response.sendRedirect(request.getContextPath()+"/");
					break;
					
				case "/sucess": //Register logic
					   ShowForm(request, response,"sucess");
					break;
					
				default://404 page
					  ShowForm(request, response, "404");
					break;
			}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	
	
	// Helper Methods
	    //Render a form 
	private void ShowForm(HttpServletRequest request, HttpServletResponse response,String path) throws ServletException, IOException {
		RequestDispatcher rd=  request.getRequestDispatcher("views/"+path+".jsp");
		
		rd.forward(request, response);
	}
	
	// Login logic (get the data + validation)
	private void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		    String login= request.getParameter("login");
		    String pass= request.getParameter("pass");
		    User user = new User(login,login,pass);
		    //Validation Of Input
		      if(user.validatelogin().isEmpty()) {
		     if(UserOps.CheckUser(login, pass)) {
		    	 // Create session and redirect 
		    	 request.getSession().invalidate(); // Destroy Any Session
		    	 HttpSession session = request.getSession(true);
		    	 session.setAttribute("username", login);
		  
		    	ShowForm(request, response, "sucess");
		     }else
		    	 // Display msg error (invalid info)
		    	 request.setAttribute("ErrorCrid", "Invalid Cridentiale! "); 	
		      }
		     
		      else { request.setAttribute("errormsg", user.validatelogin());
		             user.setPassword("");
		           
		      }
		    	 
		    	 ShowForm(request, response, "index");

	}
	
	// Register logic (get the data + validation)
	private void register(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	     response.setContentType("text/html");
    	 PrintWriter out=response.getWriter();
    	 
    	 String Name     =request.getParameter("name");
    	 String Email    =request.getParameter("email");
    	 String Password =request.getParameter("pass");
    	 String ConfPass =request.getParameter("confpass");
    	 User user       =new User(Name,Email,Password);
    	 if(user.validateRegiste(Name, Email, Password, ConfPass).isEmpty()) {
    		 UserOps.AddUser(user);
    		 response.sendRedirect("registerform?msg=success");
    	 }else {
    		  request.setAttribute("ErrorMsg", user.validateRegiste(Name, Email, Password, ConfPass));
    		  request.setAttribute("value", user);
    		  ShowForm(request, response, "register");
    	 }
    
		
	}
   
}
