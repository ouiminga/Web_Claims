package org.bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bank.beans.Claim;
import org.bank.form.CreationClaimForm;

public class CreationClaimServlet extends HttpServlet {

    public static final String ATT_FORM   = "claimform";
    public static final String ATT_CLAIM  = "claim";
    public static final String VUE_SUCCES = "/WEB-INF/showClaim.jsp";
    public static final String VUE_FORM   = "/WEB-INF/creationClaim.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /*
         * À la réception d'une requête GET, simple affichage du formulaire
         */
        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        CreationClaimForm claimform = new CreationClaimForm();
        /*
         * Traitement de la requête et récupération du bean en résultant
         */
        Claim claim = claimform.inscrireClaim( request );
        /* Ajout du bean et de l'objet métier à l'objet requête */
        request.setAttribute( ATT_CLAIM, claim );
        request.setAttribute( ATT_FORM, claimform );
        if ( claimform.getErreurs().isEmpty() ) {
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
    }
}
