<%@ page pageEncoding="UTF-8"%>
<%@ page
	import="org.joda.time.DateTime, org.joda.time.format.DateTimeFormat, org.joda.time.format.DateTimeFormatter "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Création d'une réclamation</title>
<link type="text/css" rel="stylesheet" href="inc/style.css" />
</head>
<body>
	<%@ include file="/inc/menuCreation.jsp"%>
	<div>
		<%
		    int size = 20;
		    int size2 = 30;
		    int size3 = 40;

		    int maxlength = 20;
		    int maxlength2 = 40;
		    int maxlength3 = 60;
		%>
		<form method="post" action="<c:url value="/showclaim"/>">
			<fieldset>
				<legend>Informations client</legend>
				<label for="pseudoClient">Pseudo Client <span class="requis">*</span>
				</label> <input type="text" id="pseudoClient" name="pseudoClient" value=""
					size=<%= size3 %> maxlength=<%= maxlength %> /> <br />
			</fieldset>

			<fieldset>
				<legend>Informations réclamation</legend>
				<label for="montantReclame">Montant réclamé <span
					class="requis">*</span>
				</label> <input type="text" id="montantReclame" name="montantReclame"
					value="" size=<%= size3 %> maxlength=<%= maxlength %> /> <br /> <label
					for="numeroCarte">Numéro de la carte <span class="requis">*</span>
				</label> <input type="text" id="numeroCarte" name="numeroCarte" value=""
					size=<%= size3 %> maxlength=<%= maxlength %> /> <br /> <label
					for="numCompte">Numéro du compte <span class="requis">*</span>
				</label> <input type="text" id="numCompte" name="numCompte" value=""
					size=<%= size3 %> maxlength=<%= maxlength %> /> <br /> <label
					for="numReference">Numéro référence <span class="requis">*</span>
				</label> <input type="text" id="numReference" name="numReference" value=""
					size=<%= size3 %> maxlength=<%= maxlength %> /> <br /> <label
					for="numAutorisation">Numéro autorisation <span
					class="requis">*</span>
				</label> <input type="text" id="numAutorisation" name="numAutorisation"
					value="" size=<%= size3 %> maxlength=<%= maxlength %> /> <br /> <label
					for="numGAB">Numéro GAB <span class="requis">*</span>
				</label> <input type="text" id="numGAB" name="numGAB" value=""
					size=<%= size3 %> maxlength=<%= maxlength %> /> <br /> <label
					for="banqueAcquereur">Banque acquéreur <span class="requis">*</span>
				</label> <input type="text" id="banqueAcquereur" name="banqueAcquereur"
					value="" size=<%= size3 %> maxlength=<%= maxlength %> /> <br />

				<%
				    DateTime dt = new DateTime();
				%>
				<label for="dateTransaction">Date transaction <span
					class="requis">*</span>
				</label> <input type="date" id="dateTransaction" name="dateTransaction"
					value=<%= dt %> size=<%= size3 %> maxlength=<%= maxlength %> /> <br />
			</fieldset>

			<fieldset>
				<legend>Informations agent de banque</legend>
				<label for="pseudoAgent">Pseudo agent </label> <input type="text"
					id="pseudoAgent" name="pseudoAgent" value="" size=<%= size3 %>
					maxlength=<%= maxlength %> /> <br />

			</fieldset>

			<input type="submit" /> <input type="reset" /> <br />
		</form>
	</div>
</body>
</html>