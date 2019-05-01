<%@page language="java" import="FTMT.*" import="java.util.*"%>
<%@include file="verifyLogin.jsp"%>
<html>
<head>
<title>View Specific</title>
</head>
<body>
<% 
UserController uc = new UserController();
char type = (char)session.getAttribute("Type");
ArrayList<University> history = (ArrayList<University>)session.getAttribute("History"); 
String name = (String)session.getAttribute("Username"); 
String school = (String)request.getParameter("School"); 
DBController db = new DBController();

String s = uc.savedSchoolStringtoName(school);
AdminController ac = new AdminController();
University univ = ac.getUniversity(s);
Account user  = (Account)session.getAttribute("Account");
if(univ != null)
{


%>

<style>
body {
	font-family: "Lato", sans-serif;
}

html {align = center
	
}

table {
	background: -webkit-linear-gradient(left, #ffafbd, #ffc3a0);
	background: linear-gradient(to right, #ffafbd, #ffc3a0);
	font-family: 'Roboto', sans-serif;
	width: 100%;
	table-layout: fixed;
}

.div2{
background-image: url(https://www.otago.ac.nz/_assets/OtagoCorporate/gfx/campaign.jpg);

  /* Full height */
  height: 85%; 
padding: 50px;
  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;}	

.tbl-header {
	height: 300px;
	table-layout: fixed;
	background: -webkit-linear-gradient(left, #ffafbd, #ffc3a0);
	background: linear-gradient(to right, #ffafbd, #ffc3a0);
	


	font-family: 'Roboto', sans-serif;
	margin-top: 0px;
}

.tbl-content {
	height: 300px;
	margin-top: 0px;
	width: 100%;
	table-layout: fixed;
	word-break: break-all;
	word-wrap: break-word;
}

section {
	margin: 50px; th { padding : 20px 15px;
	text-align: left;
	font-weight: 500;
	font-size: 12px;
	color: #fff;
	text-transform: uppercase;
}

td {
	padding: 15px;
	text-align: left;
	vertical-align: middle;
	font-weight: 300;
	font-size: 12px;
	color: #fff;
	border-bottom: solid 1px rgba(255, 255, 255, 0.1);
	width: 100%;
	table-layout: fixed;
}

}
.tablink {
	float: left;
	  
	color: black;
	background: linear-gradient( 90deg,
      rgba(255, 225, 132, .7) 50%, rgba(255,255,255, 0) 50%),
    linear-gradient( 90deg,
      rgba(32, 113, 120, .3) 50%, rgba(255,255,255, 0) 50%),
    linear-gradient( 90deg,
      rgba(255, 150, 102, .3) 50%, rgba(255,255,255, 0) 50%),
    linear-gradient( 90deg,
      rgba(23, 76, 79, .1) 50%, rgba(255,255,255, 0) 50%);
  background-size: 7em 7em, 5em 5em, 3em 3em, 1em 1em;
  background-color: #F5E9BE;

	border: none;
	outline: none;
	cursor: pointer;
	padding: 14px 16px;
	font-size: 17px;
	width: 25%;
	-webkit-transition-duration: 0.4s; /* Safari */
	transition-duration: 0.4s;
	background-repeat: repeat-x;
}

.tablink:hover {
	  background: linear-gradient( 90deg,
      rgba(120,80,39,.9) 50%, rgba(255,255,255, 0) 50%),
    linear-gradient( 90deg,
      rgba(32, 113, 120, .9) 50%, rgba(205,133,63, .8) 50%),
    linear-gradient( 90deg,
      rgba(255, 30, 102, .9) 50%, rgba(255,255,255, 0) 50%),
    linear-gradient( 90deg,
      rgba(205,133,63, .9) 50%, rgba(255,255,255, 0) 50%);
  background-size: 7em 7em, 5em 5em, 3em 3em, 1em 1em;
  background-color: #F5E9BE;
	color: white;
	transition-delay: .1s;
}

/* Style the tab content */
.tabcontent {

	
	 background-size: 100%;
	
	text-align: center;
}

</style>
</head>


<body class=div2>

	
	<div  class="tabcontent">
		<h1>Browse Universities</h1>
		<p>Here are all Universities.</p>
	</div>


<% if (type == 'u' || type == 'U') { 
history.add(univ); %>
	<form method="post" action="UserMenu.jsp">
		<button class="tablink" >User Menu</button>

		<input name="Username" value=<%=name%> type="hidden">
	</form>
<%} %>

<%-- <%else if (type == 'a' || type == 'A') { %> --%>
<!-- 	<form method="post" action="AdminMenu.jsp"> -->
<!-- 		<button class="tablink" >Profile Menu</button> -->

<%-- 		<input name="Username" value=<%=name%> type="hidden"> --%>
<!-- 	</form> -->
<%-- <%} %> --%>

	<form method="post" action="Logout_action.jsp">
		<button class="tablink" >Logout</button>
		<input name="Logout" value="Log Out" type="hidden"> 
		<input name="Username" value=<%=name%> type="hidden">
	</form>



	<form method="post" action="UserProfileMenu.jsp">
		<button class="tablink"
			>User Settings</button>
		<input name="Edit" value="View Profile" type="hidden"> 
		<input name="Username" value=<%=name%> type="hidden">
	</form>


	<form method="post" action="SearchSchool.jsp">
		<button class="tablink"
			>Search Specific Universities</button>
		<input name="Search" value="Search for Schools" type="hidden">
		<input name="Username" value=<%=name%> type="hidden">
	</form>



	<form method="post" action="ListOfUniversities.jsp">

		<button class="tablink"
			
			>Browse All Universities</button>
		<input name="ViewSchools" value="View List of Schools" type="hidden">
		<input name="Username" value=<%=name%> type="hidden">
	</form>




	<form method="post" action="viewSavedSchool.jsp">

		<button class="tablink"
			>Your Saved Schools</button>
		<input name="SavedList" value="Saved School List" type="hidden">
		<input name="Username" value=<%=name%> type="hidden">
	</form>


	<form method="post" action="ViewHistory.jsp">
		<button class="tablink"
			>Browsing History</button>
		<input name="History" value="View Browsing History" type="hidden">
		<input name="Username" value=<%=name%> type="hidden">
	</form>
	
<form>
		<button class="tablink"
			>...</button>
		
	</form>







</body>

<body>
<table style="text-align: left; width: 100%" border="1" cellpadding="2"
cellspacing="2">
<tbody>

<tr>
<th colspan="2" align="center">Viewing School: <%=univ.getName()%>
</th>
</tr>
<tr>

<td style="vertical-align: top;">State
</td>
<td style="vertical-align: top;"><%= univ.getState()%>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Location
</td>
<td style="vertical-align: top;"><%= univ.getLocation()%>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Control
</td>
<td style="vertical-align: top;"><%= univ.getControl()%>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Number of Students
</td>
<td style="vertical-align: top;"><%= univ.getNumStudents()%>
</td>
</tr>
<tr>
<td style="vertical-align: top;">% Female
</td>
<td style="vertical-align: top;"><%= univ.getPercFemales()%>
</td>
</tr>
<tr>
<td style="vertical-align: top;"> SAT Verbal</td>
<td style="vertical-align: top;"><%= univ.getSatVerbal()%>
</td>
</tr>
<tr>
<td style="vertical-align: top;">SAT Math (avg.)
</td>
<td style="vertical-align: top;"><%= univ.getSatMath()%>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Expenses
</td>
<td style="vertical-align: top;"><%= univ.getExpenses()%>
</td>
</tr>
<tr>
<td style="vertical-align: top;">% Financial Aid
</td>
<td style="vertical-align: top;"><%= univ.getPercAid()%>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Number of Applicants
</td>
<td style="vertical-align: top;"><%= univ.getNumApply()%>
</td>
</tr>
<tr>
<td style="vertical-align: top;">% Admitted
</td>
<td style="vertical-align: top;"><%= univ.getPercAdmit()%>
</td>
</tr>
<tr>
<td style="vertical-align: top;">% Enrolled
</td>
<td style="vertical-align: top;"><%= univ.getPercEnrolled()%>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Academics Scale(1-5)
</td>
<td style="vertical-align: top;"><%= univ.getAcadScale()%>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Social Scale(1-5)
</td>
<td style="vertical-align: top;"><%=univ.getSocialScale()%>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Quality of Life Scale(1-5)
</td>
<td style="vertical-align: top;"><%=univ.getQualLife()%>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Emphases
</td>
<td>
<table style="text-align: left; width: 100%;" border="1"
cellpadding="2" cellspacing="2">
<tbody>
<% 
ArrayList<String> emphases = db.getEmphases(s);
for (String emph : emphases) 
{ %>
<tr>
<td style="vertical-align: top;"><%=emph%>
</td>
</tr>
<% } %>
</tbody>
</table>
<% if (type == 'u' || type == 'U')%>
</td>
</tr>

<tr>
<td align="center" style="vertical-align: top;">

<form method="post" action="saveSchool_action.jsp" name="SaveSchool">
    <input name="SaveSchool" value="Save School"  type="submit">
    <input name="School" value="<%=univ.getName()%>"  type="hidden">
</form>
</td>
<td align="center" style="vertical-align: top;">
<form method="post" action="viewRecommended.jsp" name="RecSchools">
    <input name="RecSchools" value="View Similar Schools"  type="submit">
    <input name="School" value="<%=univ.getName()%>"  type="hidden">
</form>

</td>
</tr>
</tbody>
</table>
<%} %>

</body>
</html>