<%@page language="java" import="FTMT.* , java.util.*"%>
<%@include file="verifyLogin.jsp"%>
<html><title>Delete Profile</title></html>
<%
	char type = request.getParameter("Type").charAt(0); 
	AdminController ac = new AdminController();
	UserController uc = new UserController();

	String currentUsername = request.getParameter("Username");
	Account acct = ac.getProfile(currentUsername);
	ArrayList<String> savedList = new ArrayList<String>();

	if(type == 'U'||type == 'u')
	{
	 savedList = uc.viewSavedSchools(currentUsername);	 
	 
	 for(String univName : savedList)
	 {
		univName = uc.savedSchoolStringtoName(univName);
		// System.out.println(univName)
		uc.removeSavedSchool(currentUsername, univName.toUpperCase());
	 }
	 response.sendRedirect("index.jsp?Error=-1");
	 return;
	}
	
	int result = ac.removeProfile(acct.getUsername());
	System.out.println("Delete (ln28) result: [" + result + "]");
	response.sendRedirect("AdminProfileMenu.jsp?Removed=" + result);
	return;
%>