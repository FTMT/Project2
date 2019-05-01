<%@page language="java" import="FTMT.*"%>
<%@include file="verifyLogin.jsp"%>
<%
AdminController ac = (AdminController)session.getAttribute("AdminController"); 
String name = request.getParameter("Name");
String location = request.getParameter("Location");
String state = request.getParameter("State");
String acadScaleStr = request.getParameter("AcadScale");
int acadScale = Integer.parseInt(acadScaleStr);
String expensesStr = request.getParameter("Expenses");
int expenses = Integer.parseInt(acadScaleStr);
String numApplyStr = request.getParameter("NumApply");
int numApply = Integer.parseInt(acadScaleStr);
String percAdmitStr = request.getParameter("PercAdmit");
double percAdmit = Double.parseDouble(percAdmitStr);
String percAidStr = request.getParameter("PercAid");
double percAid = Double.parseDouble(percAdmitStr);
String percEnrollStr = request.getParameter("PercEnroll");
double percEnroll = Double.parseDouble(percAdmitStr);
String percFemaleStr = request.getParameter("PercFemale");
double percFemale = Double.parseDouble(percAdmitStr);
String qualLifeStr = request.getParameter("QualLife");
int qualLife = Integer.parseInt(acadScaleStr);
String satMathStr = request.getParameter("SATMath");
int satMath = Integer.parseInt(acadScaleStr);
String socialScaleStr = request.getParameter("SocialScale");
int socialScale = Integer.parseInt(acadScaleStr);
String control = request.getParameter("Control");
String numStudentsStr = request.getParameter("NumStudents");
int numStudents = Integer.parseInt(acadScaleStr);
String satVerbalStr = request.getParameter("SATVerb");
int satVerbal = Integer.parseInt(acadScaleStr);

int result = ac.editUniversity(name, state, location, control, numStudents, percFemale, satVerbal,
        satMath, expenses, percAid, numApply, percAdmit, percEnroll, 
        acadScale, socialScale, qualLife);

response.sendRedirect("AdminMenu.jsp?Edited=" + result);

%>