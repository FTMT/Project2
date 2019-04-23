<%@page language="java" import="FTMT.* , java.util.*"%>
<%@include file="verifyLogin.jsp"%>
<%
	AdminController ac = (AdminController)session.getAttribute("AdminController"); 
String currentUsername = request.getParameter("Username");
	Account acct = ac.getProfile(currentUsername);
	UserController uc = (UserController)session.getAttribute("UserController");
	ArrayList<String> savedList = new ArrayList<String>();

	if(acct.getType()== 'U'|| acct.getType()== 'u')
	{
		
		savedList = uc.viewSavedSchools(currentUsername);	 
	 
	 for(String univName : savedList)
	 {
		 int index = univName.indexOf("(");
		 univName = univName.substring(0, index-1);
		// System.out.println(univName)
		uc.removeSavedSchool(currentUsername, univName.toUpperCase());
	
		

	 }
	
	}
	ac.removeProfile(acct.getUsername());
	response.sendRedirect("Menu.jsp");
%>