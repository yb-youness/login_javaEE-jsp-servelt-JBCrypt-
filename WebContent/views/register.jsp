<%@page import="com.model.User"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ include file= "./inc/header.jsp"%>
 <div class="container mt-3">
 <%   // Get the Error msg  if Existe
 
      HashMap<String, String> ErrorMsg =(HashMap<String,String>) request.getAttribute("ErrorMsg");
      String msg= request.getParameter("msg");
      User value=(User)request.getAttribute("value");
      if(msg!=null){
      
  %>
		 <div class="alert alert-dismissible alert-success">
			  <button type="button" class="close" data-dismiss="alert">&times;</button>
			  <h4 class="alert-heading">Success !</h4>
			  <p class="mb-0">User registered With success !</p>
		</div>
	<% } %>	
    <form action="<%= request.getContextPath()%>/register" method="POST">
 		 <div class="form-group">
	      <label for="name">Name</label>
	      <input type="text" name="name" class="form-control <%= ErrorMsg!=null && ErrorMsg.containsKey("name") ? "is-invalid":"" %> " 
	      id="name" aria-describedby="name" placeholder="Enter name"
	       <% if(value != null ){ %>value="<%=value.getName() %>" <% } %>
	      >
	       <div class="invalid-feedback"> <%= ErrorMsg!=null && ErrorMsg.containsKey("name") ? ErrorMsg.get("name"):"" %></div>
	    </div>
	    <div class="form-group">
	      <label for="exampleInputEmail1">Email address</label>
	      <input type="email" name="email" class="form-control l <%= ErrorMsg!=null && ErrorMsg.containsKey("email") ? "is-invalid":"" %>"
	       id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"
	       <% if(value != null ){ %>value="<%=value.getEmail() %>" <% } %>
	       >
	       <div class="invalid-feedback"> <%= ErrorMsg!=null && ErrorMsg.containsKey("email") ? ErrorMsg.get("email"):"" %></div>
	       
	    </div>
	    <div class="form-group">
	      <label for="exampleInputPassword1">Password</label>
	      <input type="password"  name="pass"  class="form-control <%= ErrorMsg!=null && ErrorMsg.containsKey("pass") ? "is-invalid":"" %> " id="exampleInputPassword1" placeholder="Password">
	       <div class="invalid-feedback"> <%= ErrorMsg!=null && ErrorMsg.containsKey("pass") ? ErrorMsg.get("pass"):"" %></div>
	    </div>
      <div class="form-group">
	      <label for="confpass">Confirm Password</label>
	      <input type="password" name="confpass"  class="form-control <%= ErrorMsg!=null && ErrorMsg.containsKey("confpass") ? "is-invalid":"" %> " id="confpass" placeholder="Confirm Password">
	       <div class="invalid-feedback"> <%= ErrorMsg!=null && ErrorMsg.containsKey("confpass") ? ErrorMsg.get("confpass"):"" %></div>
	 </div>
	   
	    <button type="submit" class="btn btn-primary">Register</button>
	      <a href="<%= request.getContextPath()%>/" class="btn btn-primary">Login</a>
    </form>
	 </div>
  <%@ include file= "./inc/footer.jsp"%></html>