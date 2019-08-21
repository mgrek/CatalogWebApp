<%@ page import="com.dir.Parameters.ParametersRus" %>
<%@ page import="com.dir.Catalog.Organization" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Find organization</title>
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	</head>
	<body class="w3-light-grey">
		<div class="w3-container w3-light-blue w3-opacity w3-left-align">
			<h1><b>Добавить новую организацию:</b></h1>
		</div>
		
		<div class="w3-container w3-margin-bottom w3-padding">
		<form method="post">
			<label><% 
				out.println("<p>" + ParametersRus.NAME.toString() + "</p>");
				%>
                  <input class="w3-input w3-light-grey" type="text" name="name"><br />
            </label>
            <label><% 
				out.println("<p>" + ParametersRus.INN.toString() + "</p>");
				%>
                  <input class="w3-input w3-light-grey" type="text" name="inn"><br />
            </label>
            <label><% 
				out.println("<p>" + ParametersRus.OGRN.toString() + "</p>");
				%>
                  <input class="w3-input w3-light-grey" type="text" name="ogrn"><br />
            </label>
            <label><% 
				out.println("<p>" + ParametersRus.ADRESS.toString() + "</p>");
				%>
                  <input class="w3-input w3-light-grey" type="text" name="adress"><br />
            </label>
            <button class="w3-btn w3-hover-light-blue w3-margin-right w3-round-medium" type="submit">Добавить</button>
		</form>
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
					    out.println("<tr><h2 class=\"w3-hover-sand\"><b> Организации не добавлены </b></h2></tr>");
					}
				%>
			</table>		
			</form>
		</div>
		
		<div class="w3-container w3-opacity w3-right-align w3-padding">
            <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='list'">Назад в главное меню</button>
        </div>
	</body>
</html>