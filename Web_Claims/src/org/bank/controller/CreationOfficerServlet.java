package org.bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bank.beans.pers_Officer;
import org.bank.form.CreationOfficerForm;

public class CreationOfficerServlet extends HttpServlet {
    public static final String ATT_FORM      = "officerform";
    public static final String ATT_OFFICEROF = "officerof";
    public static final String VUE_SUCCES    = "/WEB-INF/showOfficer.jsp";
    public static final String VUE_FORM      = "/WEB-INF/creationOfficer.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /*
         * À la réception d'une requête GET, simple affichage du formulaire
         */
        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        CreationOfficerForm officerform = new CreationOfficerForm();
        /*
         * Traitement de la requête et récupération du bean en résultant
         */
        pers_Officer officerof = officerform.inscrireUtilisateur( request );
        /* Ajout du bean et de l'objet métier à l'objet requête */
        request.setAttribute( ATT_OFFICEROF, officerof );
        request.setAttribute( ATT_FORM, officerform );
        if ( officerform.getErreurs().isEmpty() ) {
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
    }
}
