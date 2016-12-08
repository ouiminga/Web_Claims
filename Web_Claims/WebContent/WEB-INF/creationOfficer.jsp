<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.bank.beans.pers_Officer"%>
<%@ page import="org.bank.form.CreationOfficerForm"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Creation d'un agent de banque</title>
<link type="text/css" rel="stylesheet" href="form.css" />
</head>
<body>
	<%@ include file="/inc/menuCreation.jsp"%>
	<form method="post" action="<c:url value="/showofficer"/>">
		<fieldset>
			<%-- include file="/WEB-INF/createActor.jspf"--%>

			<%
			    String erreur_email = "";
			    String erreur_mdp = "";
			    String erreur_confirmation = "";
			    String erreur_pseudo = "";
			    String erreur_name = "";
			    String erreur_firstname = "";
			    String erreur_phone = "";
			    String erreur_adress = "";
			    String erreur_officerof = "";
			    int size = 40;
			    int maxlength1 = 30, maxlength2 = 40, maxlength3 = 50, maxlength4 = 60;
			    CreationOfficerForm form = (CreationOfficerForm) request.getAttribute( "officerform" );
			    pers_Officer officerof = (pers_Officer) request.getAttribute( "officerof" );
			    Map<String, String[]> parmaMap = request.getParameterMap(  );
			    System.out.println( " attributes -----" + request.getAttribute( "email" ) + " finnnn") ;
// 			    if ( request.getAttribute( "type_request" ).equals( "post" ) ) {
// 			        if ( !form.getErreurs().get( "email" ).isEmpty() )
// 			            erreur_email = form.getErreurs().get( "email" );
// 			        if ( !form.getErreurs().get( "mdp" ).isEmpty() )
// 			            erreur_mdp = form.getErreurs().get( "mdp" );
// 			        if ( !form.getErreurs().get( "confirmation" ).isEmpty() )
// 			            erreur_confirmation = form.getErreurs().get( "confirmation" );
// 			        if ( !form.getErreurs().get( "pseudo" ).isEmpty() )
// 			            erreur_pseudo = form.getErreurs().get( "pseudo" );
// 			        if ( !form.getErreurs().get( "name" ).isEmpty() )
// 			            erreur_name = form.getErreurs().get( "name" );
// 			        if ( !form.getErreurs().get( "firstname" ).isEmpty() )
// 			            erreur_firstname = form.getErreurs().get( "firstname" );
// 			        if ( !form.getErreurs().get( "phone" ).isEmpty() )
// 			            erreur_phone = form.getErreurs().get( "phone" );
// 			        if ( !form.getErreurs().get( "adress" ).isEmpty() )
// 			            erreur_adress = form.getErreurs().get( "adress" );
// 			        if ( !form.getErreurs().get( "officerof" ).isEmpty() )
// 			            erreur_officerof = form.getErreurs().get( "officerof" );
// 			    }
			%>
			<legend>Inscription</legend>
			<p>Vous pouvez vous inscrire via ce formulaire.</p>
			<label for="email">Adresse email <span class="requis">*</span></label>
			<input type="email" id="email" name="email"
				value="<c:out value="${param.email}"/>" size=<%=size%>
				maxlength=<%=maxlength4 %> /> <span class="erreur"><%=erreur_email%></span>
			<br /> <label for="mdp">Mot de passe <span class="requis">*</span></label>
			<input type="password" id="mdp" name="mdp" value="" size=<%=size%>
				maxlength=<%=maxlength1%> /> <span class="erreur"><%=erreur_mdp%></span>
			<br /> <label for="confirmation">Confirmation du mot de
				passe <span class="requis">*</span>
			</label> <input type="password" id="confirmation" name="confirmation"
				value="" size=<%=size%> maxlength=<%=maxlength1%> /> <span
				class="erreur"><%=erreur_confirmation%></span> <br /> <label
				for="pseudo">Nom d'utilisateur</label> <input type="text"
				id="pseudo" name="pseudo" value="<c:out
value="${param.pseudo}"/>"
				size=<%=size%> maxlength=<%=maxlength1 %> /> <span class="erreur"><%=erreur_pseudo%></span>
			<br /> <label for="name">Nom</label> <input type="text" id="name"
				name="name" value="<c:out
value="${param.name}"/>" size=<%=size%>
				maxlength=<%=maxlength1 %> /> <span class="erreur"><%=erreur_name%></span>
			<br /> <label for="firstname">Prénom</label> <input type="text"
				id="firstname" name="firstname"
				value="<c:out
value="${param.firstname}"/>" size=<%=size%>
				maxlength=<%=maxlength1 %> /> <span class="erreur"><%=erreur_firstname%></span>
			<br /> <label for="phone">Phone</label> <input type="text"
				id="phone" name="phone" value="<c:out
value="${param.phone}"/>"
				size=<%=size %> maxlength=<%=maxlength1 %> /> <span class="erreur"><%=erreur_phone%></span>
			<br /> <label for="adress">Adresse</label> <input type="text"
				id="adress" name="adress" value="<c:out
value="${param.adress}"/>"
				size=<%= size %> maxlength=<%=maxlength4 %> /> <span class="erreur"><%=erreur_adress%></span>
			<br /> <label for="officerof">Agent de la Banque</label> <input
				type="text" id="officerof" name="officerof"
				value="<c:out
value="${param.officerof}"/>" size=<%= size %>
				maxlength=<%=maxlength4 %> /> <span class="erreur"><%=erreur_officerof%></span>
			<br />

			<p class="${empty form.erreurs ? 'succes' :
'erreur'}">${form.resultat}</p>

			<input type="submit" value="Valider" /> <input type="reset"
				value="Remettre à zéro" /> <br />
		</fieldset>
	</form>
</body>
</html>