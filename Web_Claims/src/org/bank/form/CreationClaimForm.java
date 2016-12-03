package org.bank.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.bank.beans.Bank;
import org.bank.beans.Claim;
import org.bank.beans.pers_Client;
import org.bank.beans.pers_Officer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public final class CreationClaimForm {

    public static final String  CHAMP_PSEUDOCLIENT    = "pseudoclient";
    public static final String  CHAMP_MONTANTRECLAME  = "montantReclame";
    public static final String  CHAMP_NUMEROCARTE     = "numeroCarte";
    public static final String  CHAMP_NUMCOMPTE       = "numCompte";
    public static final String  CHAMP_NUMREFERENCE    = "numReference";
    public static final String  CHAMP_NUMAUTORISATION = "numAutorisation";
    public static final String  CHAMP_NUMGAB          = "numGAB";
    public static final String  CHAMP_BANQUEACQUEREUR = "banqueAcquereur";
    public static final String  CHAMP_DATETRANSACTION = "dateTransaction";
    public static final String  CHAMP_PSEUDOAGENT     = "pseudoAgent";

    private String              resultat;
    private Map<String, String> erreurs               = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Claim inscrireClaim( HttpServletRequest req ) {

        String pseudoclient = getValeurChamp( req, CHAMP_PSEUDOCLIENT );
        String montantReclame = getValeurChamp( req, CHAMP_MONTANTRECLAME );
        String numeroCarte = getValeurChamp( req, CHAMP_NUMEROCARTE );
        String numCompte = getValeurChamp( req, CHAMP_NUMCOMPTE );
        String numReference = getValeurChamp( req, CHAMP_NUMREFERENCE );
        String numAutorisation = getValeurChamp( req, CHAMP_NUMAUTORISATION );
        String numGAB = getValeurChamp( req, CHAMP_NUMGAB );
        String banqueAcquereur = getValeurChamp( req, CHAMP_BANQUEACQUEREUR );
        String dateTransaction = getValeurChamp( req, CHAMP_DATETRANSACTION );
        String pseudoAgent = getValeurChamp( req, CHAMP_PSEUDOAGENT );

        Claim claim = new Claim();

        try {
            validationPseudoClient( pseudoclient );
        } catch ( Exception e ) {
            setErreur( CHAMP_PSEUDOCLIENT, e.getMessage() );
        }
        pers_Client client = new pers_Client();
        client.setName( pseudoclient );
        claim.setClient( client );

        try {
            claim.setMontantReclame( validationMontantReclame( montantReclame ) );
        } catch ( Exception e ) {
            setErreur( CHAMP_MONTANTRECLAME, e.getMessage() );
        }

        try {
            claim.setNumCarte( validationNumCarte( numeroCarte ) );
        } catch ( Exception e ) {
            setErreur( CHAMP_NUMEROCARTE, e.getMessage() );
        }

        try {
            claim.setNumCompte( validationNumCompte( numCompte ) );
        } catch ( Exception e ) {
            setErreur( CHAMP_NUMCOMPTE, e.getMessage() );
        }

        try {
            claim.setNumReference( validationNumReference( numReference ) );
        } catch ( Exception e ) {
            setErreur( CHAMP_NUMREFERENCE, e.getMessage() );
        }

        try {
            claim.setNumAutorisation( validationNumAutorisation( numAutorisation ) );
        } catch ( Exception e ) {
            setErreur( CHAMP_NUMAUTORISATION, e.getMessage() );
        }

        try {
            claim.setNumeroGAB( validationNumGAB( numGAB ) );
        } catch ( Exception e ) {
            setErreur( CHAMP_NUMGAB, e.getMessage() );
        }

        try {
            validationBanqueAcquereur( banqueAcquereur );
        } catch ( Exception e ) {
            setErreur( CHAMP_BANQUEACQUEREUR, e.getMessage() );
        }
        Bank bank = new Bank();
        bank.setName( banqueAcquereur );
        claim.setBanqueAcquereur( bank );

        try {
            validationDateTransaction( dateTransaction );
        } catch ( Exception e ) {
            setErreur( CHAMP_DATETRANSACTION, e.getMessage() );
        }
        DateTimeFormatter formatter = DateTimeFormat.forPattern( "dd/MM/yyyy HH:mm:ss" );
        DateTime dateTransac = formatter.parseDateTime( dateTransaction );
        claim.setDateTransaction( dateTransac );

        try {
            validationPseudoAgent( pseudoAgent );
        } catch ( Exception e ) {
            setErreur( CHAMP_PSEUDOAGENT, e.getMessage() );
        }
        pers_Officer agent = new pers_Officer();
        agent.setPseudo( pseudoAgent );
        claim.setAgent( agent );

        if ( erreurs.isEmpty() ) {
            resultat = "Succès de l'inscription.";
        } else {
            resultat = "Échec de l'inscription.";
        }
        return claim;
    }

    private void validationPseudoClient( String pseudoclient ) throws Exception {
        if ( pseudoclient != null && pseudoclient.trim().length() != 0 && pseudoclient.trim().length() < 3 ) {
            throw new Exception( "Merci de saisir un pseudo client valide." );
        } else {
            throw new Exception( "Merci de saisir un pseudo client." );
        }
    }

    private long validationMontantReclame( String montantReclame ) throws Exception {
        long temp;
        if ( montantReclame != null ) {
            try {
                temp = Long.parseLong( montantReclame );
                if ( temp < 0 ) {
                    throw new Exception( "Le montant réclamé doit être un nombre positif." );
                }
            } catch ( NumberFormatException e ) {
                temp = -1;
                throw new Exception( "Le montant réclamé doit être un nombre." );
            }
        } else {
            temp = -1;
            throw new Exception( "Merci d'entrer un montant réclamé." );
        }
        return temp;
    }

    private long validationNumCarte( String numeroCarte ) throws Exception {
        long temp;
        if ( numeroCarte != null ) {
            try {
                temp = Long.parseLong( numeroCarte );
                if ( temp < 0 ) {
                    throw new Exception( "Le numéro de carte doit être un nombre positif." );
                }
            } catch ( NumberFormatException e ) {
                temp = -1;
                throw new Exception( "Le numéro de carte doit être un nombre." );
            }
        } else {
            temp = -1;
            throw new Exception( "Merci d'entrer un numéro de carte." );
        }
        return temp;
    }

    private long validationNumCompte( String numCompte ) throws Exception {
        long temp;
        if ( numCompte != null ) {
            try {
                temp = Long.parseLong( numCompte );
                if ( temp < 0 ) {
                    throw new Exception( "Le numéro de compte doit être un nombre positif." );
                }
            } catch ( NumberFormatException e ) {
                temp = -1;
                throw new Exception( "Le numéro de compte doit être un nombre." );
            }
        } else {
            temp = -1;
            throw new Exception( "Merci d'entrer un numéro de compte." );
        }
        return temp;
    }

    private long validationNumReference( String numReference ) throws Exception {
        long temp;
        if ( numReference != null ) {
            try {
                temp = Long.parseLong( numReference );
                if ( temp < 0 ) {
                    throw new Exception( "Le numéro de référence doit être un nombre positif." );
                }
            } catch ( NumberFormatException e ) {
                temp = -1;
                throw new Exception( "Le numéro de référence doit être un nombre." );
            }
        } else {
            temp = -1;
            throw new Exception( "Merci d'entrer un numéro de référence." );
        }
        return temp;
    }

    private long validationNumAutorisation( String numAutorisation ) throws Exception {
        long temp;
        if ( numAutorisation != null ) {
            try {
                temp = Long.parseLong( numAutorisation );
                if ( temp < 0 ) {
                    throw new Exception( "Le numéro d'autorisation doit être un nombre positif." );
                }
            } catch ( NumberFormatException e ) {
                temp = -1;
                throw new Exception( "Le numéro d'autorisation doit être un nombre." );
            }
        } else {
            temp = -1;
            throw new Exception( "Merci d'entrer un numéro d'autorisation." );
        }
        return temp;
    }

    private long validationNumGAB( String numGAB ) throws Exception {
        long temp;
        if ( numGAB != null ) {
            try {
                temp = Long.parseLong( numGAB );
                if ( temp < 0 ) {
                    throw new Exception( "Le numéro du GAB doit être un nombre positif." );
                }
            } catch ( NumberFormatException e ) {
                temp = -1;
                throw new Exception( "Le numéro du GAB doit être un nombre." );
            }
        } else {
            temp = -1;
            throw new Exception( "Merci d'entrer un numéro du GAB." );
        }
        return temp;
    }

    private void validationBanqueAcquereur( String banqueAcquereur ) throws Exception {

    }

    private void validationDateTransaction( String dateTransaction ) throws Exception {
        // on ne valide pas les dates parce que le champs
        // date est de format date a la base donc il ne peux y avoir d'erreur

    }

    private void validationPseudoAgent( String pseudoAgent ) throws Exception {
        if ( pseudoAgent != null && pseudoAgent.trim().length() != 0 && pseudoAgent.trim().length() < 3 ) {
            throw new Exception( "Merci de saisir un pseudo d'agent valide." );
        } else {
            throw new Exception( "Merci de saisir un pseudo d'agent." );
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

    public static boolean isNum( String chaine ) {
        boolean valeur = true;
        char[] tab = chaine.toCharArray();

        for ( char carac : tab ) {
            if ( !Character.isDigit( carac ) && valeur ) {
                valeur = false;
            }
        }
        return valeur;
    }

}
