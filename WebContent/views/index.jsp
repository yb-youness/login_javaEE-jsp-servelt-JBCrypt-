<%@page import="com.model.User"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ include file= "./inc/header.jsp"%>
    <div class="container mt-3">
   <%
    // Get the hash map contains the error msgs
       HashMap<String, String> msg = new HashMap<String, String>();
       msg= (HashMap<String,String>)request.getAttribute("errormsg");
       String ErrorCrid= (String)request.getAttribute("ErrorCrid");
       User value=(User)request.getAttribute("value");
           if(ErrorCrid !=null){
        	  //out.print(ErrorCrid);
        	  
   %>
	 <div class="alert alert-dismissible alert-danger">
		  <button type="button" class="close" data-dismiss="alert">&times;</button>
		  <h4 class="alert-heading">Error !</h4>
		  <p class="mb-0"><%= ErrorCrid %></p>
	</div>
   <% }%>
  <form action="<%= request.getContextPath() %>/login" method="POST">
   <div class="form-group">
     <label for="exampleInputEmail1">Email address</label>
     <input type="text" name="login" class="form-control <%=msg!=null && msg.containsKey("login") ? "is-invalid":"" %> "
       <% if(value != null ){ %>value="<%=value.getEmail() %>" <% } %>
      id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email or login">	
     <div class="invalid-feedback"> <%= msg!=null && msg.containsKey("login") ? msg.get("login"):"" %></div>
     </div>
   <div class="form-group">
     <label for="exampleInputPassword1">Password</label>
     <input type="password"  name="pass" class="form-control  <%= msg!=null && msg.containsKey("pass") ? "is-invalid":"" %>" id="exampleInputPassword1" placeholder="Password">
     <div class="invalid-feedback"> <%=msg!=null &&  msg.containsKey("pass") ? msg.get("pass"):"" %></div>
   </div>
   <button type="submit" class="btn btn-primary">Login</button>
    <a href="<%= request.getContextPath() %>/registerform" class="btn btn-primary">Register</a>
</form>
    </div> 
  <%@ include file= "./inc/footer.jsp"%>