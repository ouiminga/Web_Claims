package org.bank.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.bank.beans.Bank;
import org.bank.beans.pers_Client;

public final class CreationClientForm {

    public static final String  CHAMP_EMAIL      = "email";
    public static final String  CHAMP_PASS       = "mdp";
    public static final String  CHAMP_CONF       = "confirmation";
    public static final String  CHAMP_PSEUDO     = "pseudo";
    public static final String  CHAMP_NAME       = "name";
    public static final String  CHAMP_FIRSTNAME  = "firstname";
    public static final String  CHAMP_PHONE      = "phone";
    public static final String  CHAMP_ADRESS     = "adress";
    public static final String  CHAMP_CUSTOMEROF = "customerof";

    private String              resultat;
    private Map<String, String> erreurs          = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public pers_Client inscrireUtilisateur( HttpServletRequest req ) {
        String email = getValeurChamp( req, CHAMP_EMAIL );
        String mdp = getValeurChamp( req, CHAMP_PASS );
        String confirmation = getValeurChamp( req, CHAMP_CONF );
        String pseudo = getValeurChamp( req, CHAMP_PSEUDO );
        String name = getValeurChamp( req, CHAMP_NAME );
        String firstname = getValeurChamp( req, CHAMP_FIRSTNAME );
        String phone = getValeurChamp( req, CHAMP_PHONE );
        String adress = getValeurChamp( req, CHAMP_ADRESS );
        String customerof = getValeurChamp( req, CHAMP_CUSTOMEROF );

        pers_Client client = new pers_Client();
        try {
            validationMail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        client.setMail( email );
        try {
            validationPass( mdp, confirmation );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
            setErreur( CHAMP_CONF, null );
        }
        client.setPass( mdp );
        try {
            validationPseudo( pseudo );
        } catch ( Exception e ) {
            setErreur( CHAMP_PSEUDO, e.getMessage() );
        }
        client.setPseudo( pseudo );

        try {
            validationName( name );
        } catch ( Exception e ) {
            setErreur( CHAMP_NAME, e.getMessage() );
        }
        client.setName( name );

        try {
            validationFirstName( firstname );
        } catch ( Exception e ) {
            setErreur( CHAMP_FIRSTNAME, e.getMessage() );
        }
        client.setFirstName( firstname );

        try {
            validationPhone( phone );
        } catch ( Exception e ) {
            setErreur( CHAMP_PHONE, e.getMessage() );
        }
        client.setPhone( phone );

        try {
            validationAdress( adress );
        } catch ( Exception e ) {
            setErreur( CHAMP_ADRESS, e.getMessage() );
        }
        client.setAdress( adress );

        Bank bank = new Bank();
        try {
            validationBank( customerof );
            bank.setName( customerof );
        } catch ( Exception e ) {
            setErreur( CHAMP_CUSTOMEROF, e.getMessage() );
        }
        client.setCustomerOf( bank );

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Échec de l'inscription.";
        }
        return client;
    }

    private void validationBank( String customerof ) throws Exception {
        if ( customerof != null && customerof.trim().length() != 0 && customerof.trim().length() < 3 ) {
            throw new Exception( "Merci de saisir une banque valide." );
        } else {
            throw new Exception( "Merci de saisir une banque." );
        }
    }

    /**
     * Valide le prenom saisi.
     */
    private void validationFirstName( String firstname ) throws Exception {
        if ( firstname != null && firstname.trim().length() != 0 && firstname.trim().length() < 3 ) {
            throw new Exception( "Merci de saisir un prenom valide." );
        } else {
            throw new Exception( "Merci de saisir un prenom." );
        }
    }

    /**
     * Valide le phone saisi.
     */
    private void validationPhone( String phone ) throws Exception {
        if ( phone != null && phone.trim().length() != 0 && phone.trim().length() < 3 ) {
            throw new Exception( "Merci de saisir un numero de telephone valide." );
        } else {
            throw new Exception( "Merci de saisir un numero de telephone." );
        }
    }

    /**
     * Valide l'adresse saisie.
     */
    private void validationAdress( String adress ) throws Exception {
        if ( adress != null && adress.trim().length() != 0 && adress.trim().length() < 3 ) {
            throw new Exception( "Merci de saisir une adresse valide." );
        } else {
            throw new Exception( "Merci de saisir une adresse." );
        }
    }

    /**
     * Valide le mail saisi.
     */
    private void validationMail( String mail ) throws Exception {
        if ( mail != null && mail.trim().length() != 0 ) {
            if ( !mail.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }

    /**
     * Valide les mots de passe saisis.
     */
    private void validationPass( String mdp, String confirmation ) throws Exception {
        if ( mdp != null && mdp.trim().length() != 0 &&
                confirmation != null && confirmation.trim().length() != 0 ) {
            if ( !mdp.equals( confirmation ) ) {
                throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
            } else if ( mdp.trim().length() < 3 ) {
                throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
        }
    }

    /**
     * Valide le nom de client saisi.
     */
    private void validationName( String name ) throws Exception {
        if ( name != null && name.trim().length() != 0 && name.trim().length() < 3 ) {
            throw new Exception( "Merci de saisir un nom valide." );
        } else {
            throw new Exception( "Merci de saisir un nom." );
        }
    }

    private void validationPseudo( String pseudo ) throws Exception {
        if ( pseudo != null && pseudo.trim().length() != 0 && pseudo.trim().length() < 3 ) {
            throw new Exception( "Merci de saisir un pseudo valide." );
        } else {
            throw new Exception( "Merci de saisir un pseudo." );
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