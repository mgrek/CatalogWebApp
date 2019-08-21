<%@ page import="com.dir.Parameters.ParametersRus" %>
<%@ page import="com.dir.Catalog.Organization" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Organization</title>
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	</head>
	
	<body class="w3-light-grey">
		<div class="w3-container w3-light-blue w3-opacity w3-left-align">
			<h1><b>Организации:</b></h1>
		</div>
		<div class="w3-container w3-padding-16 w3-center">
			<form action="list" method="get">
			<table class="w3-table-all">				
				<%
					List<Organization> organizations = (List<Organization>) request.getAttribute("organizations");
					if (organizations != null && !organizations.isEmpty()) {
					    out.println("<tr>");
						out.println("<th><h3 class=\"w3-hover-sand\" style=\"text-shadow:1px 1px 0 #444\">" + ParametersRus.NAME.toString() + "</h3></th>");
						out.println("<th><h3 class=\"w3-hover-sand\" style=\"text-shadow:1px 1px 0 #444\">" + ParametersRus.INN.toString() + "</h3></th>");
						out.println("<th><h3 class=\"w3-hover-sand\" style=\"text-shadow:1px 1px 0 #444\">" + ParametersRus.OGRN.toString() + "</h3></th>");
						out.println("<th><h3 class=\"w3-hover-sand\" style=\"text-shadow:1px 1px 0 #444\">" + ParametersRus.ADRESS.toString() + "</h3></th>");
						out.println("</tr>");
					    for (Organization org : organizations) {
							out.println("</tr>");
							out.println("<th><h4>" + org.getName() + "</h4></th>");
							out.println("<th><h4>" + org.getINN() + "</h4></th>");
							out.println("<th><h4>" + org.getOGRN() + "</h4></th>");
							out.println("<th><h4>" + org.getAdress() + "</h4></th>");
							out.println("</tr>");
					    }					    
					} else {
					    out.println("<tr><h2 class=\"w3-hover-sand\"><b> Организации отсутствуют </b></h2></tr>");
					}
				%>
			</table>		
			</form>
		</div>		
		
		<div class="w3-bar w3-padding-large w3-padding-16">
			<button class="w3-btn w3-hover-light-blue w3-round-large w3-opacity" onclick="location.href='find'"><h4><b>Найти организацию</b></h4></button>
            <button class="w3-btn w3-hover-light-blue w3-round-large w3-opacity" onclick="location.href='add'"><h4><b>Добавить организацию</b></h4></button>
		</div>
	</body>
</html>