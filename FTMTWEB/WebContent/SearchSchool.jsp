<%@page language="java" import="FTMT.*" import="java.util.*"%>
<%@include file="verifyLogin.jsp"%>
<html>
<body>
<%
String error = request.getParameter("Error");
if (error != null)
{
 if (error == "1")
 {
	%><h3>Please fill out at least one field</h3><%
 }
}
%>
</body>

<%
UserController uc = (UserController)session.getAttribute("UserController");
String name = request.getParameter("Username");
Account user = uc.getUser(name);
University univ = (University)session.getAttribute("University");
%>
<style>
body {
	font-family: "Lato", sans-serif;
}

html {align = center;
	
}

table {
	background: -webkit-linear-gradient(left, #ffafbd, #ffc3a0);
	background: linear-gradient(to right, #ffafbd, #ffc3a0);
	font-family: 'Roboto', sans-serif;
	width: 100%;
	table-layout: fixed;
}

.div2{
background-image: url(http://sydney.edu.au/dam/corporate/images/architecture/quadrangle/high-quad-shot1.jpg/_jcr_content/renditions/cq5dam.web.1440.960.2x.jpeg);

  /* Full height */
  height: 85%; 

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;}	



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
	padding: 12px 12px;
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


<body class = div2>

	<div id="UserMenu" class="tabcontent">
		<h1>User Menu</h1>
		<p>Welcome <%=user.getFirstName()%> select a tab to get started!</p>
	</div>
	








	<form method="post" action="UserMenu.jsp">
		<button class="tablink" >User Menu</button>

		<input name="Username" value=<%=name%> type="hidden">
	</form>


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


<form method="post" action="Search_action.jsp" name="SearchSchool"><br>
<table style="text-align: left; width: 266px; height: 228px;"
border="1" >
<tbody>
<tr>
<td style="vertical-align: top;">School<br>
</td>
<td style="vertical-align: top;"><input name="School" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">State<br>
</td>
<td style="vertical-align: top;"><input name="State" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">Location<br>
</td>
<td style="vertical-align: top;"><input name="Location" value= ><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Control<br>
</td>
<td style="vertical-align: top;"><input name="Control" value= ><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">numStudentsLow<br>
</td>
<td style="vertical-align: top;"><input name="numStudentsLow" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">numStudentsHigh<br>
</td>
<td style="vertical-align: top;"><input name="numStudentsHigh" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">percFemLow<br>
</td>
<td style="vertical-align: top;"><input name="percFemLow" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">percFemHigh<br>
</td>
<td style="vertical-align: top;"><input name="percFemHigh" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">satVerbLow<br>
</td>
<td style="vertical-align: top;"><input name="satVerbLow" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">satVerbHigh<br>
</td>
<td style="vertical-align: top;"><input name="satVerbHigh" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">satMathLow<br>
</td>
<td style="vertical-align: top;"><input name="satMathLow" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">satMathHigh<br>
</td>
<td style="vertical-align: top;"><input name="satMathHigh" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">expensesLow<br>
</td>
<td style="vertical-align: top;"><input name="expensesLow" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">expensesHigh<br>
</td>
<td style="vertical-align: top;"><input name="expensesHigh" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">percFinAidLow<br>
</td>
<td style="vertical-align: top;"><input name="percFinAidLow" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">percFinAidHigh<br>
</td>
<td style="vertical-align: top;"><input name="percFinAidHigh" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">numAppLow<br>
</td>
<td style="vertical-align: top;"><input name="numAppLow" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">numAppHigh<br>
</td>
<td style="vertical-align: top;"><input name="numAppHigh" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">percAdmitLow<br>
</td>
<td style="vertical-align: top;"><input name="percAdmitLow" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">percAdmitHigh<br>
</td>
<td style="vertical-align: top;"><input name="percAdmitHigh" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">percEnrolledLow<br>
</td>
<td style="vertical-align: top;"><input name="percEnrolledLow" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">percEnrolledHigh<br>
</td>
<td style="vertical-align: top;"><input name="percEnrolledHigh" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">acadScaleLow<br>
</td>
<td style="vertical-align: top;"><input name="acadScaleLow" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">acadScaleHigh<br>
</td>
<td style="vertical-align: top;"><input name="acadScaleHigh" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">socialScaleLow<br>
</td>
<td style="vertical-align: top;"><input name="socialScaleLow" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">socialScaleHigh<br>
</td>
<td style="vertical-align: top;"><input name="socialScaleHigh" value= > </td>
</tr>
<tr>
<td style="vertical-align: top;">qualLifeLow<br>
</td>
<td style="vertical-align: top;"><input name="qualLifeLow" value=> </td>
</tr>
<tr>
<td style="vertical-align: top;">qualLifeHigh<br>
</td>
<td style="vertical-align: top;"><input name="qualLifeHigh" value=> </td>
</tr>
<tr>
<td style="vertical-align: top;">emphases1<br>
</td>
<td style="vertical-align: top;"><input name="emphases1" value=> </td>
</tr>
<tr>
<td style="vertical-align: top;">emphases2<br>
</td>
<td style="vertical-align: top;"><input name="emphases2" value=> </td>
</tr>
<tr>
<td style="vertical-align: top;">emphases3<br>
</td>
<td style="vertical-align: top;"><input name="emphases3" value=> </td>
</tr>
<tr>
<td style="vertical-align: top;"><input value="Search"
name="Search" type="submit"></td>
<td style="vertical-align: top;"><input value="Reset"
name="Reset" type="reset"></td>
</tr>
</tbody>
</table>

</form>

</body>
</html>