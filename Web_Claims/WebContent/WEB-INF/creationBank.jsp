<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.bank.beans.Bank"%>
<%@ page import="org.bank.form.CreationBankForm"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Création d'une banque</title>
<link type="text/css" rel="stylesheet" href="form.css" />
</head>
<body>
	<%@ include file="/inc/menuCreation.jsp"%>
	<%
	    int size = 40;
	    int maxlength1 = 30, maxlength2 = 40, maxlength3 = 50, maxlength4 = 60;
	    Bank bank = request.getAttribute( "ATT_BANK" ) != null
	            ? (Bank) request.getAttribute( "ATT_BANK" ) : new Bank();
	    CreationBankForm form = request.getAttribute( "ATT_FORM" ) != null
	            ? (CreationBankForm) request.getAttribute( "ATT_FORM" ) : new CreationBankForm();
	    Map<String, String> erreurs = form.getErreurs() != null
	            ? (Map<String, String>) form.getErreurs() : new HashMap<String, String>();
	%>
	<form method="post" action="/showbank">
	   <form method="post" action="<c:url value="/showofficer"/>">
	
		<fieldset>
			<legend>Création d'une banque</legend>
			<p>Vous pouvez ajouter une banque via ce formulaire.</p>
			<label for="nom">Nom</label> <input type="text" id="nom" name="nom"
				value="<c:out
value="${param.nom}"/>" size=<%=size%>
				maxlength=<%=maxlength1 %> /> <span class="erreur">${erreurs['nom']}</span>
			<br /> <label for="adress">Adresse</label> <input type="text"
				id="adress" name="adress" value="<c:out
value="${param.adress}"/>"
				size=<%= size %> maxlength=<%=maxlength4 %> /> <span class="erreur">${erreurs['adress']}</span>
			<br /> <input type="submit" value="Valider" /> <input type="reset"
				value="Remettre à zéro" /> <br />
			<p class="${empty form.erreurs ? 'succes' :
'erreur'}">${form.resultat}</p>
		</fieldset>
	</form>
</body>
</html>