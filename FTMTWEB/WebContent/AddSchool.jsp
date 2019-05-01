<%@page language="java" import="FTMT.*" import="java.util.*"%>
<%@include file="verifyLogin.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add University Form</title>
</head>
<form method="post" action="AddSchool_action.jsp" name="addUser">
<table style="text-align: left; width: 100%;" border="1">
<tbody>
<tr>
<th>
Add University
</th>
<td align="right" colspan="4" rowspan="1" style="vertical-align: top;">
    <input name="AddSchool" value="Add University" type="submit">
</td>
</tr>
<tr>
<td>Name</td>
<td><input name="SchoolName">
</td>
</tr>
<tr>
<td>State</td>
<td><input name="State">
</td>
</tr>
<tr>
<td>Location</td>
<td><input name="Location">
</td>
</tr>
<tr>
<td>Control</td>
<td><input name="Control">
</td>
</tr>
<tr>
<td>AcadScale</td>
<td><input name="AcadScale">
</td>
</tr>
<tr>
<td>Expenses</td>
<td><input name="Expenses">
</td>
</tr>
<tr>
<td>Number Applied</td>
<td><input name="NumApply">
</td>
</tr>
<tr>
<td>Percent Admitted</td>
<td><input name="PercAdmit">
</td>
</tr>
<tr>
<td>Percent Aided</td>
<td><input name="PercAid">
</td>
</tr>
<tr>
<td>Percent Enrolled</td>
<td><input name="PercEnroll">
</td>
</tr>
<tr>
<td>Percentage of Females</td>
<td><input name="PercFemale">
</td>
</tr>
<tr>
<td>Quality of Life (out of 5)</td>
<td><input name="QualLife">
</td>
</tr>
<tr>
<td>SAT Math Score</td>
<td><input name="SATMath">
</td>
</tr>
<tr>
<td>Social Scale (out of 5)</td>
<td><input name="SocialScale">
</td>
</tr>
<tr>
<td>Number of Students</td>
<td><input name="NumStudents">
</td>
</tr>
<tr>
<td>SAT Verbal Score</td>
<td><input name="SATVerb">
</td>
</tr>
</tbody>
</table>
</form>
</html>