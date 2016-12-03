package org.bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bank.beans.pers_Client;
import org.bank.form.CreationClientForm;

public class CreationClientServlet extends HttpServlet {

    public static final String ATT_FORM       = "customerform";
    public static final String ATT_CUSTOMEROF = "customerof";
    public static final String VUE_SUCCES     = "/WEB-INF/showClient.jsp";
    public static final String VUE_FORM       = "/WEB-INF/creationClient.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /*
         * À la réception d'une requête GET, simple affichage du formulaire
         */
        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        CreationClientForm customerform = new CreationClientForm();
        /*
         * Traitement de la requête et récupération du bean en résultant
         */
        pers_Client customerof = customerform.inscrireUtilisateur( request );
        /* Ajout du bean et de l'objet métier à l'objet requête */
        request.setAttribute( ATT_CUSTOMEROF, customerof );
        request.setAttribute( ATT_FORM, customerform );
        if ( customerform.getErreurs().isEmpty() ) {
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
    }
}
