/**
 * 
 */
package org.bank.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author OuimingaLT
 *
 */
public class pers_Actor implements Serializable {

    private static long           nbrActor;

    protected String              name;
    protected String              firstName;
    protected String              phone;
    protected String              mail;
    protected String              pseudo;
    protected String              mdp;
    protected String              adress;
    protected Map<Object, Object> furtherInfo = new HashMap<>();

    /**
     * @return the pseudo
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * @param pseudo
     *            the pseudo to set
     */
    public void setPseudo( String pseudo ) {
        this.pseudo = pseudo;
    }

    /**
     * @return the mdp
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * @param mdp
     *            the mdp to set
     */
    public void setPass( String mdp ) {
        this.mdp = mdp;
    }

    /**
     * @return the nbrActor
     */
    public static long getNbrActor() {
        return nbrActor;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName( String name ) {
        this.name = name;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     *            the phone to set
     */
    public void setPhone( String phone ) {
        this.phone = phone;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail
     *            the mail to set
     */
    public void setMail( String mail ) {
        this.mail = mail;
    }

    /**
     * @return the adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress
     *            the adress to set
     */
    public void setAdress( String adress ) {
        this.adress = adress;
    }

    /**
     * @return the furtherInfo
     */
    public Map<Object, Object> getFurtherInfo() {
        return furtherInfo;
    }

    /**
     * @param furtherInfo
     *            the furtherInfo to set
     */
    public void setFurtherInfo( Map<Object, Object> furtherInfo ) {
        this.furtherInfo = furtherInfo;
    }

    /**
     * 
     */
    public pers_Actor() {
        // TODO Auto-generated constructor stub
        nbrActor++;
    }

}
