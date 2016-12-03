package org.bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bank.beans.Bank;
import org.bank.form.CreationBankForm;

public class CreationBankServlet extends HttpServlet {
    public static final String ATT_FORM   = "formbank";
    public static final String ATT_BANK   = "bank";
    public static final String VUE_SUCCES = "/WEB-INF/showBank.jsp";
    public static final String VUE_FORM   = "/WEB-INF/creationBank.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /*
         * À la réception d'une requête GET, simple affichage du formulaire
         */
        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        CreationBankForm formbank = new CreationBankForm();
        /*
         * Traitement de la requête et récupération du bean en résultant
         */
        Bank bank = formbank.inscrireBank( request );
        /* Ajout du bean et de l'objet métier à l'objet requête */
        request.setAttribute( ATT_BANK, bank );
        request.setAttribute( ATT_FORM, formbank );
        if ( formbank.getErreurs().isEmpty() ) {
            this.getServletContext().getRequestDispatcher( VUE_SUCCES ).forward( request, response );
        } else {
            this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
        }
    }
}
