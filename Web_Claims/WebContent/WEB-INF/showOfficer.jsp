<%@page import="org.bank.beans.pers_Officer"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.bank.beans.*"%>
<%@ page import="org.bank.controller.*"%>
<%@ page import="org.bank.form.*"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Affichage d'une commande</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/style.css"/>" />
</head>
<body>
	<%@ include file="/inc/menuConsultation.jsp"%>
	<%
	    pers_Officer officerof = new pers_Officer();
	    CreationOfficerForm officerform = new CreationOfficerForm();

	    officerof = ( request.getAttribute( "ATT_OFFICEROF" ) instanceof pers_Officer
	            ? (pers_Officer) request.getAttribute( "ATT_OFFICEROF" ) : new pers_Officer() );
	    officerform = ( request.getAttribute( "ATT_FORM" ) instanceof CreationOfficerForm
	            ? (CreationOfficerForm) request.getAttribute( "ATT_FORM" ) : new CreationOfficerForm() );
	%>
	<div id="corps">
		<p class="info">${ form.resultat }</p>
		<p>Client</p>
		<p>
			Nom :
			<%= officerof.getName() %>
		</p>
		<p>
			Prenom :
			<%= officerof.getFirstName() %>
		</p>
		<p>
			Adresse :<%=officerof.getAdress()%>
		</p>
		<p>
			Numéro de téléphone :<%=officerof.getPhone()%>
		</p>
		<p>
			Email :<%= officerof.getMail() %>
		</p>
		<p>
			Nom d'utilisateur :<%=officerof.getPseudo()%>
		</p>
	</div>
</body>
</html>
