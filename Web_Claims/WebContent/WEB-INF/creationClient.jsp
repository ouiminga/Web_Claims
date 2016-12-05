<%@page import="org.bank.form.CreationClientForm"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.bank.beans.pers_Client"%>
<%@ page import="org.bank.form.CreationClientForm"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>s
<meta charset="utf-8" />
<title>Creation d'un client</title>
<link type="text/css" rel="stylesheet" href="form.css" />
</head>
<body>
	<%@ include file="/inc/menuCreation.jsp"%>
	<form method="post" action="<c:url value="/showclient"/>">
		<fieldset>
			<%-- include file="/WEB-INF/createActor.jspf"--%>

			<%
			    int size = 40;
			    int maxlength1 = 30, maxlength2 = 40, maxlength3 = 50, maxlength4 = 60;
			    pers_Client customerof = request.getAttribute( "ATT_CUSTOMEROF" ) != null
			            ? (pers_Client) request.getAttribute( "ATT_CUSTOMEROF" ) : new pers_Client();
			    CreationClientForm form = request.getAttribute( "ATT_FORM" ) != null
			            ? (CreationClientForm) request.getAttribute( "ATT_FORM" ) : new CreationClientForm();
			    Map<String, String> erreurs = form.getErreurs() != null ? (Map<String, String>) form.getErreurs()
			            : new HashMap<String, String>();
			%>
			<legend>Inscription</legend>
			<p>Vous pouvez vous inscrire via ce formulaire.</p>
			<label for="email">Adresse email <span class="requis">*</span></label>
			<input type="email" id="email" name="email"
				value="<c:out value="${param.email}"/>" size=<%=size%>
				maxlength=<%=maxlength4 %> /> <span class="erreur">${erreurs['email']}</span>
			<br /> <label for="motdepasse">Mot de passe <span
				class="requis">*</span></label> <input type="password" id="motdepasse"
				name="motdepasse" value="" size=<%=size%> maxlength=<%=maxlength1%> />
			<span class="erreur">${erreurs['motdepasse']}</span> <br /> <label
				for="confirmation">Confirmation du mot de passe <span
				class="requis">*</span>
			</label> <input type="password" id="confirmation" name="confirmation"
				value="" size=<%=size%> maxlength=<%=maxlength1%> /> <span
				class="erreur">${erreurs['confirmation']}</span> <br /> <label
				for="pseudo">Nom d'utilisateur</label> <input type="text"
				id="pseudo" name="pseudo" value="<c:out
value="${param.pseudo}"/>"
				size=<%=size%> maxlength=<%=maxlength1 %> /> <span class="erreur">${erreurs['pseudo']}</span>
			<br /> <label for="nom">Nom</label> <input type="text" id="nom"
				name="nom" value="<c:out
value="${param.nom}"/>" size=<%=size%>
				maxlength=<%=maxlength1 %> /> <span class="erreur">${erreurs['nom']}</span>
			<br /> <label for="prenom">Prénom</label> <input type="text"
				id="prenom" name="prenom" value="<c:out
value="${param.prenom}"/>"
				size=<%=size%> maxlength=<%=maxlength1 %> /> <span class="erreur">${erreurs['prenom']}</span>
			<br /> <label for="phone">Phone</label> <input type="text"
				id="phone" name="phone" value="<c:out
value="${param.phone}"/>"
				size=<%=size%> maxlength=<%=maxlength1 %> /> <span class="erreur">${erreurs['phone']}</span>
			<br /> <label for="adress">Adresse</label> <input type="text"
				id="adress" name="adress" value="<c:out
value="${param.adress}"/>"
				size=<%= size %> maxlength=<%=maxlength4 %> /> <span class="erreur">${erreurs['adress']}</span>
			<br />
			<p class="${empty form.erreurs ? 'succes' :
'erreur'}">${form.resultat}</p>


			<label for="customerofbank">Client de la Banque</label> <input
				type="text" id="customerofbank" name="customerofbank"
				value="<c:out
value="${param.customerofbank}"/>" size=<%= size %>
				maxlength=<%=maxlength4 %> /> <span class="erreur">${erreurs['customerofbank']}</span>
			<br /> <input type="submit" value="Valider" /> <input type="reset"
				value="Remettre à zéro" /> <br />
		</fieldset>
	</form>
</body>
</html>