

<%@ include file="./inc/header.jsp" %>

<div class="container mt-3">
<%  
//Check If The Sesssion is Set
    if(request.getSession().getAttribute("username")==null)  response.sendRedirect(request.getContextPath()+"/");  // If Not Redirect to the Login Page To Enter info 
    else{ 
    	// Get The session Info (name Of The User)
    	String name=(String) request.getSession().getAttribute("username");   
%>
 <h1>Hello <%= name %>  </h1>
 <%  }	 %>
<div>

<%@ include file="./inc/footer.jsp" %>