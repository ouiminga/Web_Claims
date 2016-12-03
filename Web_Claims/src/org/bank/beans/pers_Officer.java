/**
 * 
 */
package org.bank.beans;

/**
 * @author OuimingaLT
 *
 */
public class pers_Officer extends pers_Actor {

    private static long nbrOfficer;

    private long        numOfficer;
    private Bank        officerOfBank;

    /**
     * @return the officerOfBank
     */
    public Bank getOfficerOfBank() {
        return officerOfBank;
    }

    /**
     * @param officerOfBank
     *            the officerOfBank to set
     */
    public void setOfficerOfBank( Bank officerOfBank ) {
        this.officerOfBank = officerOfBank;
    }

    /**
     * @return the nbrOfficer
     */
    public static long getNbrOfficer() {
        return nbrOfficer;
    }

    /**
     * @return the numOfficer
     */
    public long getNumOfficer() {
        return numOfficer;
    }

    /**
     * @param numOfficer
     *            the numOfficer to set
     */
    public void setNumOfficer( long numOfficer ) {
        this.numOfficer = numOfficer;
    }

    /**
     * 
     */
    public pers_Officer() {
        // TODO Auto-generated constructor stub
        nbrOfficer++;
    }

}
