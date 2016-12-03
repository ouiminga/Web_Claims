package org.bank.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.bank.beans.Bank;

public final class CreationBankForm {
    public static final String  CHAMP_NAME   = "name";
    public static final String  CHAMP_ADRESS = "adress";

    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Bank inscrireBank( HttpServletRequest req ) {
        String name = getValeurChamp( req, CHAMP_NAME );
        String adress = getValeurChamp( req, CHAMP_ADRESS );

        Bank bank = new Bank();
        try {
            validationName( name );
        } catch ( Exception e ) {
            setErreur( CHAMP_NAME, e.getMessage() );
        }
        bank.setName( name );

        try {
            validationAdress( adress );
        } catch ( Exception e ) {
            setErreur( CHAMP_ADRESS, e.getMessage() );
        }
        bank.setAdress( adress );

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Échec de l'inscription.";
        }
        return bank;
    }

    /**
     * Valide l'adresse saisie.
     */
    private void validationAdress( String adress ) throws Exception {
        if ( adress != null && adress.trim().length() != 0 && adress.trim().length() < 3 ) {
            if ( adress != null && adress.trim().length() < 3 ) {
                throw new Exception( "Merci de saisir une adresse valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse." );
        }
    }

    /**
     * Valide le nom de client saisi.
     */
    private void validationName( String name ) throws Exception {
        if ( name != null && name.trim().length() < 3 ) {
            throw new Exception( "Le nom doit contenir au moins 3 caractères." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest req, String nomChamp ) {
        String valeur = req.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}